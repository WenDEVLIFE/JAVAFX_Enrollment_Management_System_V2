/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
/**
 *
 * @author Administrator
 */
public class Changecredentials {
public static Stage stage2;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public void ChangeUsername(String currentuser, String newuser, String confirmation_password,
            String user_receiver, ActionEvent event, TextField currentusernamefield, 
            TextField newusernamefield, PasswordField passwordfield1, 
            Label setLabelUser, Label setLabelUser1, Label setLabelUser2,
            Label setLabelUser3, Label setLabelUser4, Label setLabelUser5, 
            Label setLabelUser6, Label setUserLabel7, Label setUserLabel8,
            Label setLabelUser9, Label setUserLabel10, Label setUserLabel11, 
            Label setUserLabel12) throws IOException {
            String user_receiver1= setLabelUser3.getText();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        // Check if the current username exists in the database
        String query = "SELECT * FROM usertable WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, currentuser);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Validate the current password
                    String storedPasswordHash = resultSet.getString("password");
                    byte[] storedSalt = resultSet.getBytes("salt");
                    String hashedPassword = hashPasswordPBKDF2(confirmation_password, storedSalt);

                    if (hashedPassword.equals(storedPasswordHash)) {
                        // Update the username
                        String updateQuery = "UPDATE usertable SET username = ? WHERE username = ?";
                        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                            updateStatement.setString(1, newuser);
                            updateStatement.setString(2, currentuser);

                            // Execute the update statement
                            int rowsUpdated = updateStatement.executeUpdate();

                            if (rowsUpdated > 0) {
                                // Notify the user about the successful username change
                                // If the current user is the receiver, update the label and open the dashboard
                                if (currentuser.equals(user_receiver1)) {
                                    user_receiver = newuser;
                                setLabelUser.setText( user_receiver);
                                setLabelUser1.setText(user_receiver);
                                setLabelUser2.setText( user_receiver);
                                setLabelUser3.setText(user_receiver);
                                setLabelUser4.setText(user_receiver);
                                setLabelUser5.setText(user_receiver);
                                setLabelUser6.setText(user_receiver);
                                setUserLabel7.setText(user_receiver);
                                setUserLabel8.setText(user_receiver);
                                setLabelUser9.setText(user_receiver);
                                setUserLabel10.setText( user_receiver);
                                setUserLabel11.setText( user_receiver);
                                setUserLabel12.setText( user_receiver);
                                }
                                // Display a success message
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("System Message");
                                alert.setHeaderText(null);
                                alert.setContentText("User changed successfully");
                                alert.showAndWait();
                                currentusernamefield.setText("");
                                newusernamefield.setText("");
                                passwordfield1.setText("");

                                System.out.println("Username changed successfully.");
                                System.runFinalization();
                            } else {
                                System.out.println("Failed to change username.");
                            }
                        }
                    } else {
                        System.out.println("Incorrect current password.");
                    }
                } else {
                    System.out.println("User not found.");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    private String hashPasswordPBKDF2(String password, byte[] salt) {
        try {
            int iterations = 10000; // Number of iterations
            int keyLength = 256; // Key length in bits

            char[] passwordChars = password.toCharArray();
            PBEKeySpec spec = new PBEKeySpec(passwordChars, salt, iterations, keyLength);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hashedBytes = factory.generateSecret(spec).getEncoded();

            // Convert the byte array to a hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

   public void ChangePassword(String username1, String passwordold, String passwordnew, TextField enterusername, PasswordField oldpassword, PasswordField newpassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
    if (verifyPasswordLength(passwordnew)) {
        // Check if the current password exists in the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Prepare the SQL statement
            PreparedStatement statement = connection.prepareStatement("SELECT password, salt FROM usertable WHERE username = ?");
            String usertype = username1;

            // Set the parameters
            statement.setString(1, usertype);

            // Execute the statement and get the result set
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set is empty
            if (!resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Username not found");
                alert.showAndWait();
            }

            // Retrieve the hashed password and salt from the database
            String storedPassword = resultSet.getString("password").trim();
            byte[] salt = resultSet.getBytes("salt");

            // Hash the user's input current password with the retrieved salt
            String hashedInputPassword = hashPassword(passwordold.trim(), salt);

            // Compare the hashed input password with the stored password
            if (!hashedInputPassword.equals(storedPassword)) {
                // The current password is incorrect
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Current password is incorrect");
                alert.showAndWait();
            } else {
                // Generate a new salt for the new password
                byte[] newSalt = generateSalt();

                // Hash the new password using the new salt
                String hashedNewPassword = hashPassword(passwordnew.trim(), newSalt);

                // Update the password and salt in the database
PreparedStatement updateStatement = connection.prepareStatement("UPDATE usertable SET password = ?, salt = ? WHERE username = ?");
                updateStatement.setString(1, hashedNewPassword);
                updateStatement.setBytes(2, newSalt);
                updateStatement.setString(3, usertype);
                updateStatement.executeUpdate();

                // Notify the user that the password has been changed
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Password successfully changed");
                alert.showAndWait();
                
               enterusername.setText("");
               oldpassword.setText("");
             newpassword.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

private byte[] generateSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16]; // You can adjust the salt size as needed
    random.nextBytes(salt);
    return salt;
}

// MD5 function 1
private String hashPassword(String passwordnew, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
    int iterations = 10000; // Number of iterations
    int keyLength = 256; // Key length in bits

    PBEKeySpec spec = new PBEKeySpec(passwordnew.toCharArray(), salt, iterations, keyLength);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    byte[] hashedNewPassword = factory.generateSecret(spec).getEncoded();

    return bytesToHex(hashedNewPassword);
}

// MD5 function 2
private String bytesToHex(byte[] bytes) {
    StringBuilder hexString = new StringBuilder();
    for (byte aByte : bytes) {
        hexString.append(String.format("%02x", aByte));
    }
    return hexString.toString();
}

public boolean verifyPasswordLength(String passwordold) {
    int length = passwordold.length();
    return length >= 8 && length <= 12;
}
}