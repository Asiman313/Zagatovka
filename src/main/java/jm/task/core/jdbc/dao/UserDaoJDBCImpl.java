package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
//    private static final Connection connection = Util.getUtil().getConnection();
    public UserDaoJDBCImpl() {
    }
    public void createUsersTable() {
//        String create = """
//                CREATE TABLE IF NOT EXISTS User
//                (
//                ID BIGINT AUTO_INCREMENT PRIMARY KEY,
//                Name CHARACTER (200),
//                LastName CHARACTER(200),
//                Age INTEGER
//                )
//                """;
//
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(create);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }

    public void dropUsersTable() {
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate("DROP TABLE IF EXISTS user");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    public void saveUser(String name, String lastName, byte age) {
//        String save = """
//                INSERT INTO user (name, lastName, age)
//                VALUES (?, ?, ?)
//                """;
//        try (PreparedStatement statement = connection.prepareStatement(save)) {
//            statement.setString(1, name);
//            statement.setString(2, lastName);
//            statement.setByte(3, age);
//
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }

    public void removeUserById(long id) {
//        String remove = """
//                DELETE FROM user WHERE ID = id
//                """;
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(remove);
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        String zapros = "SELECT * FROM user";
//        try (Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(zapros)) {
//            while (resultSet.next()) {
//                User user = new User(resultSet.getString(2), resultSet.getString(3),resultSet.getByte(4));
//                user.setId(resultSet.getLong(1));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
return null;
    }

    public void cleanUsersTable() {
//        String clean = "TRUNCATE TABLE user";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(clean);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
