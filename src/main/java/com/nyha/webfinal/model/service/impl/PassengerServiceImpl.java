package com.nyha.webfinal.model.service.impl;


import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.dao.PassengerDao;
import com.nyha.webfinal.model.dao.impl.PassengerDaoImpl;
import com.nyha.webfinal.entity.Passenger;
import com.nyha.webfinal.model.service.PassengerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;


public class PassengerServiceImpl implements PassengerService {
    static Logger logger = LogManager.getLogger();
    private PassengerDao passengerDao = new PassengerDaoImpl();

    @Override
    public Optional<String> addPassenger(Passenger passenger) throws ServiceException {
        try {
            passengerDao.addPassenger(passenger);
        } catch (DaoException e) {
            logger.error("add passenger error, " + passenger, e);
            throw new ServiceException("add passenger error, " + passenger, e);
        }
        return Optional.empty();
    }
}
