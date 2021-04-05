package com.nyha.webfinal.model.dao.impl;

import com.nyha.webfinal.model.dao.ColumnName;
import com.nyha.webfinal.model.dao.UserDao;
import com.nyha.webfinal.model.entity.User;
import com.nyha.webfinal.exception.DaoException;
import com.nyha.webfinal.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//fixme переопределить методы
public class UserDaoImpl implements UserDao {

    static Logger logger = LogManager.getLogger();
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT user_id, email, username, role FROM railway.users WHERE email = ? AND password = ?";
    private static final String FIND_ALL_USERS = "SELECT user_id, email, username, role FROM railway.users";
    private static final String ADD_USER = "INSERT INTO `users` (`user_id`, `email`, `password`, `username`, `role`) VALUES (?, ?, ?, ?, ?)";


    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(ColumnName.USER_ID));
                user.setEmail(resultSet.getString(ColumnName.USER_EMAIL));
                user.setUsername(resultSet.getString(ColumnName.USER_USERNAME));
                user.setRole(User.Role.valueOf(resultSet.getString(ColumnName.USER_ROLE).toUpperCase()));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("search error", e);
            throw new DaoException("search error", e);
        }
        return users;
    }

    @Override
    public Optional<User> findEntityById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean add(User user) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Long id) throws DaoException {
        return false;
    }

    @Override
    public boolean remove(User user) throws DaoException {
        return false;
    }

    @Override
    public User update(User user) throws DaoException {
        return null;
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(ColumnName.USER_ID));
                user.setEmail(resultSet.getString(ColumnName.USER_EMAIL));
                user.setUsername(resultSet.getString(ColumnName.USER_USERNAME));
                user.setRole(User.Role.valueOf(resultSet.getString(ColumnName.USER_ROLE).toUpperCase()));
                userOptional = Optional.ofNullable(user);
            }
        } catch (SQLException e) {
            logger.error("search error", e);
            throw new DaoException("search error", e);
        }
        return userOptional;
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean addUser(User user, String password) throws DaoException {
        boolean isAdd;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
            preparedStatement.setString(1, user.getId().toString());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getRole().toString());
            isAdd = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("add error", e);
            throw new DaoException("add error", e);
        }
        return isAdd;
    }
}
