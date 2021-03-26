package com.nyha.webfinal.dao.impl;

import com.nyha.webfinal.dao.UserDao;
import com.nyha.webfinal.entity.User;
import com.nyha.webfinal.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

//переопределить методы
//fixme
public class UserDaoImpl implements UserDao {

    static Logger logger = LogManager.getLogger();
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT user_id, email, username, role FROM railway.users WHERE email = ? AND password = ?";
    private static final String FIND_ALL_USERS = "SELECT user_id, email, username, role FROM railway.users";

    @Override
    public List<User> findAll() throws DaoException {
//переделать конекшин
        //fixme
        /////////////////////
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost/mysql?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        //String url = "jdbc:mysql://localhost:3036/railway";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "1234");
//        prop.put("autoReconnect", "true");
//        prop.put("characterEncoding", "UTF-8");
//        prop.put("useUnicode", "true");
//        prop.put("serverTimezone", "UTC");
//        prop.put("verifyServerCertificate", "false");
//        prop.put("useSSL", "true");
        ////////////////////

        List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, prop);
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setRole(User.Role.valueOf(resultSet.getString(4).toUpperCase()));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return users;
    }

    @Override
    public Optional<User> findEntityById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean add(User user) throws DaoException {
        return false;
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
    public Optional<User> findByEmailAndPassword(String email, String password) throws DaoException {
        //переделать конекшин
        //fixme
        /////////////////////
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost/mysql?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        //String url = "jdbc:mysql://localhost:3036/railway";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "1234");
//        prop.put("autoReconnect", "true");
//        prop.put("characterEncoding", "UTF-8");
//        prop.put("useUnicode", "true");
//        prop.put("serverTimezone", "UTC");
//        prop.put("verifyServerCertificate", "false");
//        prop.put("useSSL", "true");
        ////////////////////

        Optional<User> userOptional = Optional.empty();
        try (Connection connection = DriverManager.getConnection(url, prop);
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setRole(User.Role.valueOf(resultSet.getString(4).toUpperCase()));
                userOptional = Optional.ofNullable(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return userOptional;
    }

    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean addUser(User user, String password) throws DaoException {
        return false;
    }
}
