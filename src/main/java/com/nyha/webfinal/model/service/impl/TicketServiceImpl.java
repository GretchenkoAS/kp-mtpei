package com.nyha.webfinal.model.service.impl;

import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.dao.TicketDao;
import com.nyha.webfinal.model.dao.impl.TicketDaoImpl;
import com.nyha.webfinal.model.entity.Ticket;
import com.nyha.webfinal.model.service.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {
    private TicketDao ticketDao = new TicketDaoImpl();

    @Override
    public List<Ticket> findAllTickets() throws ServiceException {
        List<Ticket> tickets;
        try {
            tickets = ticketDao.findAll();
        } catch (DaoException e) {
            logger.error("search error", e);
            throw new ServiceException("search error", e);
        }
        return tickets;
    }

    @Override
    public List<Ticket> findUsersTickets(Long userId) throws ServiceException {
        List<Ticket> tickets;
        try {
            tickets = ticketDao.findUsersTickets(userId);
        } catch (DaoException e) {
            logger.error("search error", e);
            throw new ServiceException("search error", e);
        }
        return tickets;
    }
}
