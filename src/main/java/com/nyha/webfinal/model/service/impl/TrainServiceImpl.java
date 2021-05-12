package com.nyha.webfinal.model.service.impl;

import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.dao.TrainDao;
import com.nyha.webfinal.model.dao.impl.TrainDaoImpl;
import com.nyha.webfinal.model.entity.Route;
import com.nyha.webfinal.model.entity.ShortTrainData;
import com.nyha.webfinal.model.entity.Train;
import com.nyha.webfinal.model.service.TrainService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrainServiceImpl implements TrainService {
    private TrainDao trainDao = new TrainDaoImpl();

    @Override
    public List<Train> findAllTrains() throws ServiceException {
        List<Train> trains;
        try {
            trains = trainDao.findAll();
        } catch (DaoException e) {
            logger.error("search trains error", e);
            throw new ServiceException("search trains error", e);
        }
        return trains;
    }

    @Override
    public List<ShortTrainData> findTrainByStations(String departureStation, String arrivalStation) throws ServiceException {
        List<ShortTrainData> resultTrains = new ArrayList<>();
        try {
            List<Train> trains = trainDao.findTrainByStation(departureStation);
            for (Train train : trains) {
                ShortTrainData shortTrainData = new ShortTrainData();
                boolean flag = false;
                for (Route route : train.getRoutes()) {
                    if (departureStation.equals(route.getStation())) {
                        shortTrainData.setDepartureTime(route.getTime().toString().substring(0,5));
                        flag = true;
                    }
                    if (arrivalStation.equals(route.getStation()) && flag) {
                        shortTrainData.setTrainId(train.getId());
                        shortTrainData.setDepartureStation(departureStation);
                        shortTrainData.setArrivalStation(arrivalStation);
                        shortTrainData.setArrivalTime(route.getTime().toString().substring(0,5));
                        double price = calculatePrice(train, departureStation, arrivalStation);
                        shortTrainData.setPrice(price);
                        resultTrains.add(shortTrainData);
                        break;
                    }
                }
            }
        } catch (DaoException e) {
            logger.error("search error, " + departureStation + ", " + arrivalStation, e);
            throw new ServiceException("search error, " + departureStation + ", " + arrivalStation, e);
        }
        return resultTrains;
    }

    @Override
    public Optional<Train> findTrainById(Long trainId) throws ServiceException {
        Optional<Train> train;
        try {
            train = trainDao.findTrainById(trainId);
        } catch (DaoException e) {
            logger.error("search train error, " + trainId, e);
            throw new ServiceException("search train error, " + trainId, e);
        }
        return train;
    }

    private double calculatePrice(Train train, String departureStation, String arrivalStation) {
        double price = 0;
        boolean flag = false;
        for (Route route : train.getRoutes()) {
            if (departureStation.equals(route.getStation())) {
                flag = true;
            }
            if (arrivalStation.equals(route.getStation())) {
                break;
            }
            if (flag) {
                price += route.getPrice();
            }
        }
        return price;
    }
}
