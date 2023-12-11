/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinteraction;

/**
 *
 * @author Administrator
 */
import functions.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseHandler {
private Connection connection;
    private final String jdbcUrl;
    private final String username1;
    private final String password1;

    public DatabaseHandler(String jdbcUrl, String username1, String password1) {
        this.jdbcUrl = jdbcUrl;
        this.username1 = username1;
        this.password1= password1;
    }

   public ObservableList<User> fetchDataFromDatabase() {
    ObservableList<User> userList = FXCollections.observableArrayList();

    try (Connection connection= DriverManager.getConnection(jdbcUrl, username1, password1);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT UserID, username, role FROM usertable")) {

        // Populate the ObservableList with data from the ResultSet
        while (resultSet.next()) {
            int id = resultSet.getInt("UserID");
            String username = resultSet.getString("username");
            String role = resultSet.getString("role");

            userList.add(new User(id, username, role));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return userList;
}

    void closeConnection() {
    try {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Database connection closed.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception appropriately, such as logging it
    }
}
}
