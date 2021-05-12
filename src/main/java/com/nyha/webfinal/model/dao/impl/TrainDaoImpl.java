package com.nyha.webfinal.model.dao.impl;

import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.model.dao.ColumnName;
import com.nyha.webfinal.model.dao.TrainDao;
import com.nyha.webfinal.model.entity.Route;
import com.nyha.webfinal.model.entity.Train;
import com.nyha.webfinal.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainDaoImpl implements TrainDao {
    private static final String FIND_ALL_TRAINS = "SELECT trains.train_id, trains.number_of_seats, routes.station, routes.route_id, routes.time, routes.price FROM trains JOIN routes ON trains.train_id = routes.train_id order by trains.train_id, routes.time";
    private static final String FIND_TRAINS_BY_ID = "SELECT trains.train_id, trains.number_of_seats, routes.station, routes.route_id, routes.time, routes.price FROM trains JOIN routes ON trains.train_id = routes.train_id where trains.train_id = ?  order by trains.train_id, routes.time";
    private static final String ADD_TRAIN = "INSERT INTO `trains` (`number_of_seats`) VALUES (?)";
    private static final String FIND_ROUTES_BY_STATIONS = "SELECT route_id, train_id, time, station FROM routes WHERE station = ?";

    @Override
    public List<Train> findAll() throws DaoException {
        List<Train> trains = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_TRAINS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Train train = new Train();
                List<Route> routes = new ArrayList<>();
                train.setId(resultSet.getLong(ColumnName.TRAIN_ID));
                train.setNumberOfSeats(resultSet.getInt(ColumnName.TRAIN_NUMBER_OF_SEATS));
                do {
                    Route route = new Route();
                    route.setId(resultSet.getLong(ColumnName.ROUTE_ID));
                    route.setStation(resultSet.getString(ColumnName.ROUTE_STATION));
                    route.setTime(resultSet.getTime(ColumnName.ROUTE_TIME));
                    route.setTrainNumber(resultSet.getLong(ColumnName.ROUTE_TRAIN_NUMBER));
                    routes.add(route);
                } while (resultSet.next() && train.getId().equals(resultSet.getLong(ColumnName.TRAIN_ID)));
                if (!resultSet.isAfterLast()) {
                    resultSet.previous();
                }
                train.setRoutes(routes);
                trains.add(train);
            }
        } catch (SQLException e) {
            logger.error("search trains error", e);
            throw new DaoException("search trains error", e);
        }
        return trains;
    }

    @Override
    public boolean addTrain(Train train) throws DaoException {
        boolean isAdd;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_TRAIN)) {
            preparedStatement.setInt(1, train.getNumberOfSeats());
            isAdd = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("add error, " + train, e);
            throw new DaoException("add error, " + train, e);
        }
        return isAdd;
    }

    @Override
    public List<Train> findTrainByStation(String departureStation) throws DaoException {
        List<Train> trains = new ArrayList<>();
        List<Route> routes = findRoutesByStations(departureStation);
        if (routes.isEmpty()) {
            return trains;
        }
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_TRAINS_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            for (Route route : routes) {
                preparedStatement.setLong(1, route.getTrainNumber());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Train train = new Train();
                    List<Route> trainRoutes = new ArrayList<>();
                    train.setId(resultSet.getLong(ColumnName.TRAIN_ID));
                    train.setNumberOfSeats(resultSet.getInt(ColumnName.TRAIN_NUMBER_OF_SEATS));
                    do {
                        Route trainRoute = new Route();
                        trainRoute.setId(resultSet.getLong(ColumnName.ROUTE_ID));
                        trainRoute.setStation(resultSet.getString(ColumnName.ROUTE_STATION));
                        trainRoute.setTime(resultSet.getTime(ColumnName.ROUTE_TIME));
                        trainRoute.setTrainNumber(resultSet.getLong(ColumnName.ROUTE_TRAIN_NUMBER));
                        trainRoutes.add(trainRoute);
                    } while (resultSet.next() && train.getId().equals(resultSet.getLong(ColumnName.TRAIN_ID)));
                    if (!resultSet.isAfterLast()) {
                        resultSet.previous();
                    }
                    train.setRoutes(trainRoutes);
                    trains.add(train);
                }
                preparedStatement.clearParameters();
            }
        } catch (SQLException e) {
            logger.error("search trains error", e);
            throw new DaoException("search trains error", e);
        }
        return trains;
    }

    private List<Route> findRoutesByStations(String departureStation) throws DaoException {
        List<Route> routes = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ROUTES_BY_STATIONS)) {
            preparedStatement.setString(1, departureStation);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Route route = new Route();
                route.setId(resultSet.getLong(ColumnName.ROUTE_ID));
                route.setStation(resultSet.getString(ColumnName.ROUTE_STATION));
                route.setTime(resultSet.getTime(ColumnName.ROUTE_TIME));
                route.setTrainNumber(resultSet.getLong(ColumnName.ROUTE_TRAIN_NUMBER));
                routes.add(route);
            }
        } catch (SQLException e) {
            logger.error("search error, " + departureStation , e);
            throw new DaoException("search error, " + departureStation, e);
        }
        return routes;
    }
}