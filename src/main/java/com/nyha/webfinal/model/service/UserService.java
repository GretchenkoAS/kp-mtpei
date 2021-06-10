package com.nyha.webfinal.model.service;

import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByEmail(String email) throws ServiceException;
    Optional<User> findUserByEmailAndPassword(String email, String password) throws ServiceException;
    List<User> findAllUsers() throws ServiceException;
    Optional<String> addUser(User user, String password) throws ServiceException;
    String changePassword(User user, String password) throws ServiceException;
    String updateUser(User user) throws ServiceException;
}
