package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.SessionAttribute;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.Ticket;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.model.service.TicketService;
import com.nyha.webfinal.model.service.impl.TicketServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ToMyTicketsPageCommand implements Command {
    public static final String NOT_TICKETS = "notTickets";
    private TicketService service = new TicketServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(PagePath.TICKETS);
        HttpSession session = request.getSession(true);
        User user = (User)session.getAttribute(SessionAttribute.USER);
        Long userId = user.getId();
        List<Ticket> tickets;
        try {
            tickets = service.findUsersTickets(userId);
            if(!tickets.isEmpty()) {
                request.setAttribute(RequestAttribute.TICKETS, tickets);
            } else {
                request.setAttribute(RequestAttribute.MESSAGE, NOT_TICKETS);
            }
        } catch (ServiceException e) {
            logger.error("search error", e);
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e);
        }
        return router;
    }

}