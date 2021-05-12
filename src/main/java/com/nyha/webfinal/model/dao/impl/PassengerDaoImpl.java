package com.nyha.webfinal.model.dao.impl;

import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.model.dao.ColumnName;
import com.nyha.webfinal.model.dao.PassengerDao;
import com.nyha.webfinal.model.entity.Passenger;
import com.nyha.webfinal.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerDaoImpl implements PassengerDao {
    private static final String FIND_ALL_PASSENGERS = "SELECT passenger_id, first_name, last_name, passport_number, phone_number, user_id FROM passengers";
    private static final String ADD_PASSENGER = "INSERT INTO `passengers` (`first_name`, `last_name`, `passport_number`, `phone_number`, `user_id`, `passenger_id`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_PASSENGERS_BY_ID = "SELECT passenger_id, first_name, last_name, passport_number, phone_number, user_id FROM passengers WHERE passenger_id = ?";

    @Override
    public List<Passenger> findAll() throws DaoException {
        List<Passenger> passengers = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_PASSENGERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setId(resultSet.getLong(ColumnName.PASSENGER_ID));
                passenger.setName(resultSet.getString(ColumnName.PASSENGER_FIRST_NAME));
                passenger.setLastName(resultSet.getString(ColumnName.PASSENGER_LAST_NAME));
                passenger.setPassportNumber(resultSet.getString(ColumnName.PASSENGER_PASSPORT_NUMBER));
                passenger.setPhoneNumber(resultSet.getString(ColumnName.PASSENGER_PHONE_NUMBER));
                passenger.setUserId(resultSet.getLong(ColumnName.USER_ID));
                passengers.add(passenger);
            }
        } catch (SQLException e) {
            logger.error("search error", e);
            throw new DaoException("search error", e);
        }
        return passengers;
    }

    @Override
    public boolean addPassenger(Passenger passenger) throws DaoException {
        boolean isAdd;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_PASSENGER);
        PreparedStatement preparedStatementFind = connection.prepareStatement(FIND_PASSENGERS_BY_ID)) {
            preparedStatementFind.setLong(1, Long.parseLong(passenger.getPassportNumber()));
            ResultSet resultSet = preparedStatementFind.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getLastName());
            preparedStatement.setString(3, passenger.getPassportNumber());
            preparedStatement.setString(4, passenger.getPhoneNumber());
            preparedStatement.setLong(5, passenger.getUserId());
            preparedStatement.setLong(6, Long.parseLong(passenger.getPassportNumber()));
            isAdd = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("add error, " + passenger, e);
            throw new DaoException("add error, " + passenger, e);
        }
        return isAdd;
    }
}
