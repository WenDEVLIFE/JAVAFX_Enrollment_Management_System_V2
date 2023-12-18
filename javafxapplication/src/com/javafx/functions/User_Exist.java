/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

/**
 *
 * @author Administrator
 */
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;



public class User_Exist {
  private TableView<User> AdminTable;
    private String username;
    private String password;
    private String selectedItemString1;

    public User_Exist(String username, String password, String selectedItemString1, TableView<User> AdminTable, ObservableList<User> userList) {
        this.username = username;
        this.password = password;
        this.selectedItemString1 = selectedItemString1;
        this.AdminTable =AdminTable;
   }

    public static String mydb_url = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    public static String myDB_username = "root";
    public static String myDB_PASSWORD = "";

    public boolean doesUsernameExist(String username) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
            String selectSQL = "SELECT COUNT(*) FROM usertable WHERE username = ?";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectSQL)) {
                selectStatement.setString(1, username);

                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
        }
        return false;
    }

    public void user_identification() {
        try {
            // Check if the username already exists in the database.
            if (doesUsernameExist(username)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("User already exists");
                alert.showAndWait();
                
                  System.gc();
   System.runFinalization();
            } else {
                try {
                    // Assuming AddUserAdminFunction.create() adds the user to the database
                AddUserAdminFunction.create(username, password, selectedItemString1, AdminTable);
                    // You might want to show a success message here
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message");
                    alert.setHeaderText(null);
                    alert.setContentText("User added successfully");
                    alert.showAndWait();
                      System.gc();
   System.runFinalization();
                } catch (NoSuchAlgorithmException | InvalidKeySpecException | ClassNotFoundException ex) {
                    // Handle exceptions related to adding the user
                    ex.printStackTrace();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            // Handle exceptions related to database connectivity
            ex.printStackTrace();
        }
    }
}