package com.nyha.webfinal.model.service;

import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.Passenger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public interface PassengerService {
    Optional<String> addPassenger(Passenger passenger) throws ServiceException;
}
