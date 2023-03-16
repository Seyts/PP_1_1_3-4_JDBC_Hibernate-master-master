package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util util = Util.getInstance();
        Connection connection = util.getConnection();

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("John", "Doe", (byte) 30);

        userService.saveUser("Jane", "Smith", (byte) 25);

        userService.saveUser("Bob", "Johnson", (byte) 40);

        userService.saveUser("Alice", "Williams", (byte) 35);

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        userService.removeUserById(1);

        userService.cleanUsersTable();
        userService.dropUsersTable();






    }
}
