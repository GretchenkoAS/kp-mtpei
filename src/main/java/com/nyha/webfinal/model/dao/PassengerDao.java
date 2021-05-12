package com.nyha.webfinal.model.dao;

import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.model.entity.Passenger;

public interface PassengerDao extends BaseDao<Passenger> {
    boolean addPassenger(Passenger passenger) throws DaoException;
}
