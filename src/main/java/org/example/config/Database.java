package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static Database instance;
    private Connection connection;
    private Database() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Database getInstance() {
        if (instance == null){
            instance = new Database();
        }
        return  instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
