package com.nyha.webfinal.model.service;

import com.nyha.webfinal.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public interface BankService {
    Optional<String> debitTheAccount(String accountNumber, double price) throws ServiceException;
}
