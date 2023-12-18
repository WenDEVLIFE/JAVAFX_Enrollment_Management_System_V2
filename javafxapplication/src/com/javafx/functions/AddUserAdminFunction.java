/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

//</editor-fold>


/**
 *
 * @author Administrator
 */
public class AddUserAdminFunction {
      private static TableView<User> AdminTable;
 private  static String username;
 private static String password;
 private static String confirmpass;
private  static String selectedItemString1;


  
 public static String mydb_url = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    public static String myDB_username = "root";  // Database username
    public static  String myDB_PASSWORD = "";  // Define your database password here
    

    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // You can adjust the salt size as needed
        random.nextBytes(salt);
        return salt;
    }
    
    // MD5 function
    private static String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 10000; // Number of iterations
        int keyLength = 256; // Key length in bits

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedNewPassword = factory.generateSecret(spec).getEncoded();

        return bytesToHex(hashedNewPassword);
    }

    // Byte to Hex conversion
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte aByte : bytes) {
            hexString.append(String.format("%02x", aByte));
        }
        return hexString.toString();
    }
    
   
    public AddUserAdminFunction (String username, String password, String selectedItemString1, TableView<User> AdminTable) {
              this.username = username; // Initialize the username instance variable
    this.password = password; // Initialize the password instance variable
                  this.selectedItemString1= selectedItemString1; // Initialize the username instance variable
                  this.AdminTable = AdminTable;

    }
  // Move the create() method outside of the main() method.
 public static void create(String username, String password, String selectedItemString1, TableView<User> AdminTable) throws NoSuchAlgorithmException, InvalidKeySpecException, ClassNotFoundException {
        
   

    // Generate a random salt for each user.
    byte[] salt = generateSalt();

    // Hash the password using PBKDF2.
    String hashedPassword = hashPassword(password, salt);

    // Create a connection to the database.
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection connection = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {

        // Get the maximum ID value from the user table.
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX(UserID) FROM usertable");
        int highestId = 0;
        if (resultSet.next()) {
            highestId = resultSet.getInt(1);
        }

        // Increment the highest ID value by 1 to get the new ID value.
        int newId = highestId + 1;

        // Create a prepared statement to insert a new user into the database.
        String insertSQL = "INSERT INTO usertable (UserID, username, password, salt, role) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

        // Set the values for the prepared statement.
        insertStatement.setInt(1, newId);
        insertStatement.setString(2, username);
        insertStatement.setString(3, hashedPassword);
        insertStatement.setBytes(4, salt);
        insertStatement.setString(5, selectedItemString1);

        // Execute the prepared statement.
        int rowsAffected = insertStatement.executeUpdate();

        // If the user was successfully added to the database, display a success message and clear the text fields.
        if (rowsAffected == 1) {
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("System Message");
        alert.setHeaderText(null);
        alert.setContentText("Successfully added a user");
        alert.showAndWait();
   User newUser = new User(newId, username, selectedItemString1);
AdminTable.getItems().add(newUser);
   System.gc();
   System.runFinalization();
        } else {
          
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
 
    public static void main(String[] args) {
        try {
        
            create(username, password, selectedItemString1, AdminTable);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
