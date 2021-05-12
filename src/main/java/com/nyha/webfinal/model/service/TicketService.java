package com.nyha.webfinal.model.service;

import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public interface TicketService {
    Logger logger = LogManager.getLogger();
    List<Ticket> findAllTickets() throws ServiceException;
    List<Ticket> findUsersTickets(Long userId) throws ServiceException;
}
