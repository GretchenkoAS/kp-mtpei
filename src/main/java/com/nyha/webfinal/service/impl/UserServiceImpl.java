package com.nyha.webfinal.service.impl;

import com.nyha.webfinal.dao.UserDao;
import com.nyha.webfinal.dao.impl.UserDaoImpl;
import com.nyha.webfinal.entity.User;
import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
//переопределить методы
//fixme
public class UserServiceImpl implements UserService {
    static Logger logger = LogManager.getLogger();
    private UserDao userDao = new UserDaoImpl();

    @Override
    public Optional<User> findUserByEmail(String email) throws ServiceException {

        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) throws ServiceException {
        try {
            Optional<User> user = userDao.findByEmailAndPassword(email, password);
            return user;
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        List<User> users = null;
        try {
            users = userDao.findAll();
        } catch (DaoException e) {
            logger.error(e);
            e.printStackTrace();
        }
        return users;
    }
}
