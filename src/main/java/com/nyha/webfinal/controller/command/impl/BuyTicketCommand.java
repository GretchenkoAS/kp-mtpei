package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.RequestParameter;
import com.nyha.webfinal.controller.SessionAttribute;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.Passenger;
import com.nyha.webfinal.model.entity.Ticket;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.model.service.BankService;
import com.nyha.webfinal.model.service.PassengerService;
import com.nyha.webfinal.model.service.TicketService;
import com.nyha.webfinal.model.service.impl.BankServiceImpl;
import com.nyha.webfinal.model.service.impl.PassengerServiceImpl;
import com.nyha.webfinal.model.service.impl.TicketServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Optional;

public class BuyTicketCommand implements Command {
    public static final String TICKET_BOUGHT = "ticketBought";


    private TicketService ticketService = new TicketServiceImpl();
    private PassengerService passengerService = new PassengerServiceImpl();
    private BankService bankService = new BankServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String trainIdStr = request.getParameter(RequestParameter.TRAIN_ID);
        Long trainId = Long.parseLong(trainIdStr);
        String departureStation = request.getParameter(RequestParameter.DEPARTURE_STATION);
        String arrivalStation = request.getParameter(RequestParameter.ARRIVAL_STATION);
        String arrivalTime = request.getParameter(RequestParameter.ARRIVAL_TIME);
        String departureTime = request.getParameter(RequestParameter.DEPARTURE_TIME);
        String priceStr = request.getParameter(RequestParameter.PRICE);
        double price = Double.parseDouble(priceStr);
        String name = request.getParameter(RequestParameter.NAME);
        String lastName = request.getParameter(RequestParameter.LAST_NAME);
        String passportNumber = request.getParameter(RequestParameter.PASSPORT_NUMBER);
        String phoneNumber = request.getParameter(RequestParameter.PHONE_NUMBER);
        String seatStr = request.getParameter(RequestParameter.SEAT);
        int seat = Integer.parseInt(seatStr);
        String dateStr = request.getParameter(RequestParameter.DATE);
        String accountNumber = request.getParameter(RequestParameter.ACCOUNT_NUMBER);

        try {
            Optional<String> message = bankService.debitTheAccount(accountNumber, price);
            if (message.isPresent()) {
                request.setAttribute(RequestAttribute.INCORRECT_DATA, message.get());
                router.setPage(PagePath.REGISTRATION);
            }
            HttpSession session = request.getSession(true);

            Passenger passenger = new Passenger();
            passenger.setPhoneNumber(phoneNumber);
            passenger.setPassportNumber(passportNumber);
            passenger.setName(name);
            passenger.setLastName(lastName);
            User user = (User) session.getAttribute(SessionAttribute.USER);
            passenger.setUserId(user.getId());

            passengerService.addPassenger(passenger);

            Ticket ticket = new Ticket();
            ticket.setPassenger(passenger);
            ticket.setTrainId(trainId);
            ticket.setDepartureStation(departureStation);
            ticket.setArrivalStation(arrivalStation);
            ticket.setSeat(seat);
            ticket.setPrice(price);
            Timestamp departureDate = Timestamp.valueOf(dateStr + " " + departureTime + ":00");
            Timestamp arrivalDate = Timestamp.valueOf(dateStr +  " " + arrivalTime + ":00");
            ticket.setDepartureDate(departureDate);
            ticket.setArrivalDate(arrivalDate);
            ticketService.addTicket(ticket);
            session.setAttribute(SessionAttribute.TICKET_BOUGHT, TICKET_BOUGHT);
            router.setPage(PagePath.MESSAGE);
            router.setRedirect();
        } catch (ServiceException e) {
            logger.error("buy ticket error", e);
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e);
        }
        return router;
    }
}
