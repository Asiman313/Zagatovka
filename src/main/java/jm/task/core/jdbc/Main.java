package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Asiman","Guliev", (byte) 27);
        userService.saveUser("Andrey","Mishurin", (byte) 29);
        userService.saveUser("Petya","Ivanov", (byte) 22);
        userService.saveUser("Irina","Fedorcova", (byte) 28);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
