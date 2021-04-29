package com.nyha.webfinal.model.service.impl;

import com.nyha.webfinal.util.PasswordEncryption;
import com.nyha.webfinal.model.dao.UserDao;
import com.nyha.webfinal.model.dao.impl.UserDaoImpl;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.service.UserService;
import com.nyha.webfinal.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

//fixme переопределить методы
public class UserServiceImpl implements UserService {
    static Logger logger = LogManager.getLogger();
    public static final String INCORRECT_EMAIL = "incorrectEmail";
    public static final String EMAIL_ALREADY_EXISTS = "emailAlreadyExists";
    public static final String INCORRECT_USERNAME = "incorrectUsername";
    public static final String INCORRECT_PASSWORD = "incorrectPassword";

    private UserDao userDao = new UserDaoImpl();

    @Override
    public Optional<User> findUserByEmail(String email) throws ServiceException {
        Optional<User> user;
        if (UserValidator.isValidEmail(email)) {
            try {
                user = userDao.findUserByEmail(email);
            } catch (DaoException e) {
                logger.error("search error", e);
                throw new ServiceException("search error", e);
            }
        } else {
            user = Optional.empty();
        }
        return user;
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) throws ServiceException {
        Optional<User> user;
        if (UserValidator.isValidEmail(email) && UserValidator.isValidPassword(password)) {
            try {
                String encodedPassword = PasswordEncryption.encrypt(password);
                user = userDao.findUserByEmailAndPassword(email, encodedPassword);
            } catch (DaoException e) {
                logger.error("search error", e);
                throw new ServiceException("search error", e);
            }
        } else {
            user = Optional.empty();
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        List<User> users = null;
        try {
            users = userDao.findAll();
        } catch (DaoException e) {
            logger.error("search error", e);
            throw new ServiceException("search error", e);
        }
        return users;
    }

    @Override
    public Optional<String> addUser(User user, String password) throws ServiceException {
        if (!UserValidator.isValidEmail(user.getEmail())) {
            return Optional.of(INCORRECT_EMAIL);
        }
        if (findUserByEmail(user.getEmail()).isPresent()) {
            return Optional.of(EMAIL_ALREADY_EXISTS);
        }
        if (!UserValidator.isValidUsername(user.getUsername())) {
            return Optional.of(INCORRECT_USERNAME);
        }
        if (!UserValidator.isValidPassword(password)) {
            return Optional.of(INCORRECT_PASSWORD);
        }
        try {
            String encodedPassword = PasswordEncryption.encrypt(password);
            userDao.addUser(user, encodedPassword);
        } catch (DaoException e) {
            logger.error("add error", e);
            throw new ServiceException("add error", e);
        }
        return Optional.empty();
    }
}
