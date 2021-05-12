package com.nyha.webfinal.model.dao;

import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.model.entity.Route;

public interface RouteDao extends BaseDao<Route> {
    boolean addRoute(Route route) throws DaoException;
}
