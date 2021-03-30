package com.nyha.webfinal.model.dao;

import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.exception.DaoException;

import java.util.Optional;

public interface UserDao extends BaseDao<Long, User> {
    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;
    Optional<User> findByEmail(String email) throws DaoException;
    boolean addUser(User user, String password) throws DaoException;
}