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
        if (UserValidator.isValidEmail(email) && UserValidator.isValidPassword(password)) {
            try {
                Optional<User> user = userDao.findByEmailAndPassword(email, password);
                return user;
            } catch (DaoException e) {
                logger.error(e);
                throw new ServiceException(e);
            }
        } else {
            // FIXME
            //добавить еррор мэсэдж
        }
        return Optional.empty();
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

    @Override
    public boolean addUser(User user, String password) throws ServiceException {
        boolean isAdd = false;
        if (UserValidator.isValidEmail(user.getEmail()) && UserValidator.isValidPassword(password)) {
            try {
                String encodedPassword = PasswordEncryption.encrypt(password);
                isAdd = userDao.addUser(user, encodedPassword);
            } catch (DaoException e) {
                logger.error(e);
                throw new ServiceException(e);
            }
        }
        else {
            // FIXME
            //добавить еррор мэсэдж
        }
        return isAdd;
    }
}
