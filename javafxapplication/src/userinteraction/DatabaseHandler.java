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
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHandler {

    private final String jdbcUrl;
    private final String username;
    private final String password;

    public DatabaseHandler(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public ObservableList<User> fetchDataFromDatabase() {
        ObservableList<User> userList = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT UserID, username, role FROM usertable");

            // Populate the ObservableList with data from the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("UserID");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");

                userList.add(new User(id, username, role));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }
}
