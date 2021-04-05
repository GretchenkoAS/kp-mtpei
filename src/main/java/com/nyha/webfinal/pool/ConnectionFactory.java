package com.nyha.webfinal.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class ConnectionFactory {
    static Logger logger = LogManager.getLogger();
    private static final String RESOURCE = "database";
    private static final ResourceBundle resourceBundle;
    private static final String URL = "url";
    private static final String DB_DRIVER = "driver";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String DATABASE_URL;
    private static final String DATABASE_PASSWORD;
    private static final String DATABASE_USERNAME;

    static {
        resourceBundle = ResourceBundle.getBundle(RESOURCE);
        String driverName = resourceBundle.getString(DB_DRIVER);
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            logger.fatal("can't register driver" + driverName + " " + e);
            throw new RuntimeException("fatal: can't register driver: " + driverName, e);
        }
        DATABASE_URL = resourceBundle.getString(URL);
        DATABASE_USERNAME = resourceBundle.getString(USERNAME);
        DATABASE_PASSWORD = resourceBundle.getString(PASSWORD);
    }

    private ConnectionFactory() {
    }

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }
}