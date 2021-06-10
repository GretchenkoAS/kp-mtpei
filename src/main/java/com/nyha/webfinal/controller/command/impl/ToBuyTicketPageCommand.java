package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.RequestParameter;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class ToBuyTicketPageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(PagePath.TICKET);
        String trainIdStr = request.getParameter(RequestParameter.TRAIN_ID);
        String departureStation = request.getParameter(RequestParameter.DEPARTURE_STATION);
        String arrivalStation = request.getParameter(RequestParameter.ARRIVAL_STATION);
        String arrivalTime = request.getParameter(RequestParameter.ARRIVAL_TIME);
        String departureTime = request.getParameter(RequestParameter.DEPARTURE_TIME);
        String price = request.getParameter(RequestParameter.PRICE);

        request.setAttribute(RequestAttribute.TRAIN_ID, trainIdStr);
        request.setAttribute(RequestAttribute.DEPARTURE_STATION, departureStation);
        request.setAttribute(RequestAttribute.ARRIVAL_STATION, arrivalStation);
        request.setAttribute(RequestAttribute.ARRIVAL_TIME, arrivalTime);
        request.setAttribute(RequestAttribute.DEPARTURE_TIME, departureTime);
        request.setAttribute(RequestAttribute.PRICE, price);
        request.setAttribute(RequestAttribute.CURRENT_DATE, LocalDate.now().toString());
        return router;
    }
}
