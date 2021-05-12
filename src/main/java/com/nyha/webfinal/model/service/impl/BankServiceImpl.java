package com.nyha.webfinal.model.service.impl;

import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.dao.BankDao;
import com.nyha.webfinal.model.dao.impl.BankDaoImpl;
import com.nyha.webfinal.model.service.BankService;

import java.util.Optional;

public class BankServiceImpl implements BankService {
    public static final String OPERATION_FAILED = "operationFailed";

    private BankDao bankDao = new BankDaoImpl();

    @Override
    public Optional<String> debitTheAccount(String accountNumber, double price) throws ServiceException {
        try {
            if (!bankDao.debitTheAccount(accountNumber, price)) {
               return Optional.of(OPERATION_FAILED);
            }
        } catch (DaoException e) {
            logger.error("debitTheAccount error, " + accountNumber, e);
            throw new ServiceException("debitTheAccount error, " + accountNumber, e);
        }
        return Optional.empty();
    }
}
