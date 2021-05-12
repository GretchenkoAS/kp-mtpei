package com.nyha.webfinal.model.dao;

import com.nyha.webfinal.exception.DaoException;

import java.util.Optional;

public interface BankDao extends BaseDao {
    boolean debitTheAccount(String accountNumber, double price) throws DaoException;
}
