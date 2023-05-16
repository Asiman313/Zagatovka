package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;


public class Util {

    private final static String USERNAME = "root";
    private final static String PASSWORD = "Asiman111!";
    private final static String URL = "jdbc:mysql://localhost:3306/User";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;
    private static SessionFactory sessionFactory = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null || sessionFactory.isClosed()) {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();

                settings.put(Environment.DRIVER, DRIVER);
                settings.put(Environment.URL, URL);
                settings.put(Environment.PASS, PASSWORD);
                settings.put(Environment.USER, USERNAME);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(Environment.SHOW_SQL, true);
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.addAnnotatedClass(User.class).buildSessionFactory(serviceRegistry);
            }
            System.out.println("CONNECT");
        } catch (Exception e) {
            System.out.println("NOT CONNECT");
            e.printStackTrace();

        }
        return sessionFactory;
    }
}


