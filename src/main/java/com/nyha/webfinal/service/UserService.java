package com.nyha.webfinal.service;

import com.nyha.webfinal.entity.User;
import com.nyha.webfinal.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByEmail(String email) throws ServiceException;
    Optional<User> findUserByEmailAndPassword(String email, String password) throws ServiceException;
    List<User> findAllUsers() throws ServiceException;
}
