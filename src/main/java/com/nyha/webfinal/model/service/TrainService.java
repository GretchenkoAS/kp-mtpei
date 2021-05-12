package com.nyha.webfinal.model.service;

import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.ShortTrainData;
import com.nyha.webfinal.model.entity.Train;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public interface TrainService {
    Logger logger = LogManager.getLogger();
    List<Train> findAllTrains() throws ServiceException;
    List<ShortTrainData> findTrainByStations(String departureStation, String arrivalStation) throws ServiceException;

}
