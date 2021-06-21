package com.nyha.webfinal.model.dao;

import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.entity.Route;

import java.sql.SQLException;

/**
 * The interface for working with database table routes
 *
 * @author Andrey Gretchenko
 * @see BaseDao
 */
public interface RouteDao extends BaseDao<Route> {
    /**
     * Adds a route
     *
     * @param route {@link Route}
     * @return boolean true if the route added successfully, else false
     * @throws DaoException if {@link SQLException} occur
     */
    boolean addRoute(Route route) throws DaoException;
}
