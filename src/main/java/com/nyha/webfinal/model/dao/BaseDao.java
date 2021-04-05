package com.nyha.webfinal.model.dao;

import com.nyha.webfinal.model.entity.Entity;
import com.nyha.webfinal.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public interface BaseDao<K, T extends Entity> {
    static Logger logger = LogManager.getLogger();

    List<T> findAll() throws DaoException;

    Optional<T> findEntityById(K id) throws DaoException;

    boolean add(T t) throws DaoException;

    boolean remove(K id) throws DaoException;

    boolean remove(T t) throws DaoException;

    T update(T t) throws DaoException;

    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error("close statement error", e);
        }
    }

    default void close(Connection connection) {
        try {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        } catch (SQLException e) {
            logger.error("close connection error", e);
        }
    }

    default void rollback(Connection connection) {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            logger.error("rollback error", e);
        }
    }
}