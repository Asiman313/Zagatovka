package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Util {

    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/User";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Asiman111!";
    private static Util util;

    public static Connection getConnection() {
        try {
            if ((connection == null) || (connection.isClosed())) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД");
        }
        return connection;
    }
}


