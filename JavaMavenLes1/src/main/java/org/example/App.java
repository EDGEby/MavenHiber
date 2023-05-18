package org.example;

import org.example.services.UserService;

import java.sql.SQLException;


public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        UserService userService = new UserService();
        User user1 = new User("Petya", 22);
        userService.saveUser(user1);
    }
}
