package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userService = new UserDaoJDBCImpl();
    public void createUsersTable() {
        userService.createUsersTable();

    }

    public void dropUsersTable() {
        userService.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userService.saveUser(name,lastName, age);
        System.out.println("User с именем - " + name + " добавлени в базу данных");
    }

    public void removeUserById(long id) {
        userService.removeUserById(id);
    }

    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    public void cleanUsersTable() {
        userService.cleanUsersTable();

    }
}
