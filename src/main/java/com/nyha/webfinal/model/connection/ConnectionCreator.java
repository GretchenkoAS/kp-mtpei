package com.nyha.webfinal.model.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.Properties;

public final class ConnectionCreator {
    static Logger logger = LogManager.getLogger();
    private static final String URL = "jdbc:mysql://localhost:3306/railway";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        Properties properties = new Properties();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException | MissingResourceException e) {
            logger.fatal("fatal error: config file " + e);
            throw new RuntimeException(e);
        }
    }

    private ConnectionCreator() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}