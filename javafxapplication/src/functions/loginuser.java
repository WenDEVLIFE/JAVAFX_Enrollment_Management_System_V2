/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import static javafxapplication.maincontroller.stage;
import userinteraction.DashboardController;

/**
 *
 * @author Administrator
 */
public class loginuser {
    
        public static Stage stage1;

    private Parent root;
    private Scene scene;
    
     // store the data from the main
public final String user;
private final String pass;

 public static String mydb_url = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    public static String myDB_username = "root";  // Database username
    public static  String myDB_PASSWORD = "";  // Define your database password here
 
    public loginuser(String user, String pass) {
           this.user = user; // Initialize the username instance variable
    this.pass= pass; // Initialize the password instance variable

    }
     
  public void loginAuthentication(String user, String pass, ActionEvent event) throws ClassNotFoundException, IOException {
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mhns_enrollment_db", "root", "")) {
        checkMySQLServerStatus(); // Check if MySQL is online before attempting to authenticate

        String sql = "SELECT username, password, salt FROM usertable WHERE username = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, user);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String storedHashedPassword = resultSet.getString("password");
                    byte[] storedSalt = resultSet.getBytes("salt");

                    if (pass.isEmpty()) {
                        displayErrorMessage("Password is required");
                    } else if (validatePassword(pass, storedSalt, storedHashedPassword)) {
                        displayWelcomeMessage(user,event);
                    } else {
                        displayErrorMessage("Incorrect username or password");
                    }
                } else {
                    displayErrorMessage("User not found");
                }
            }
        }
    } catch (SQLException e) {
        handleDatabaseConnectionError(e);
    }
}

private void handleDatabaseConnectionError(SQLException e) {
    e.printStackTrace(); // Log or handle the error appropriately
}

      public  void checkMySQLServerStatus() throws SQLException {
        try (Connection connection = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
            // Connection successful, MySQL is online.
        } catch (SQLException e) {
            // Connection failed, MySQL is offline. You can log the error or handle it as needed.
            throw e;
        }
    }

private void displayErrorMessage(String message) {
   Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Authentication failed");
                    alert.showAndWait();
}

private void displayWelcomeMessage(String user, ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Login Message");
    alert.setHeaderText(null);
    alert.setContentText("You successfully login, Good day and Welcome " + user);
    alert.showAndWait();

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/userinteraction/dashboard.fxml"));
    Parent root = loader.load();

    System.out.println("DashboardController instance: " + loader.getController());
    System.out.println("User value: " + user);

    DashboardController dashboardController = loader.getController();
    dashboardController.setuserlabel(user);
    
    // Initialize stage1 if it is null
    // to close the current scene
    if (stage1 == null) {
        stage1 = new Stage();
    }

    dashboardController.setStage(stage1);

    Scene scene = new Scene(root);
    javafx.scene.image.Image icon = new javafx.scene.image.Image(getClass().getResourceAsStream("/pictures/mabini.png"));

    stage1.setScene(scene);
    stage1.getIcons().add(icon);
    stage1.setTitle("Mabini National High School Management System Dashboard");
    stage1.show();
    stage1.setResizable(false);

    // Close the current stage
    Node sourceNode = (Node) event.getSource();
    Stage currentStage = (Stage) sourceNode.getScene().getWindow();
    currentStage.close();
}

public boolean validatePassword(String enteredPassword, byte[] storedSalt, String storedHashedPassword) {
    try {
        // Hash the entered password with the stored salt and compare with stored hash
        String computedHashedPassword = hashPassword(enteredPassword, storedSalt);
        return storedHashedPassword.equals(computedHashedPassword);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        e.printStackTrace();
        return false;
    }
}

private String hashPassword(String pass, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
    int iterations = 10000;
    int keyLength = 256;

    KeySpec keySpec = new PBEKeySpec(pass.toCharArray(), salt, iterations, keyLength);

    try {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedPassword = factory.generateSecret(keySpec).getEncoded();

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedPassword) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        throw e;
    }
}
}
