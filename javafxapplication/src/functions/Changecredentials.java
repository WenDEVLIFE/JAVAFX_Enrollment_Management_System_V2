/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;
import userinteraction.DashboardController;
/**
 *
 * @author Administrator
 */
public class Changecredentials {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public void ChangeUsername(String currentuser, String newuser, String confirmation_password, String user_receiver) {
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
                                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                   alert1.setTitle("System Message");
                                   alert1.setHeaderText(null);
                                   alert1.setContentText("User changed successfully");
                                   alert1.showAndWait();
                                    System.out.println("Username changed successfully.");
                                 System.runFinalization();
                                 
                                    if(newuser==user_receiver){
                                          DashboardController dashboardController = new DashboardController();
                                          dashboardController.setuserlabel(newuser);
                                             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                   alert.setTitle("System Message");
                                   alert.setHeaderText(null);
                                   alert.setContentText("User changed successfully");
                                   alert.showAndWait();
                                    System.out.println("Username changed successfully.");
                                 System.runFinalization();
                                    }
             
                                    // Message the user that it sucess change the username
                                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                   alert.setTitle("System Message");
                                   alert.setHeaderText(null);
                                   alert.setContentText("User changed successfully");
                                   alert.showAndWait();
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

   public void ChangePassword(String username1, String passwordold, String passwordnew) throws NoSuchAlgorithmException, InvalidKeySpecException {
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