package com.nyha.webfinal.model.dao;

import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.model.entity.Train;

import java.util.List;
import java.util.Optional;

public interface TrainDao extends BaseDao<Train> {
    boolean addTrain(Train train) throws DaoException;
    List<Train> findTrainByStation(String departureStation) throws DaoException;
    Optional<Train> findTrainById(Long trainId) throws DaoException;
}
