/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication;

import functions.loginuser;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class maincontroller {
    
    public static Stage stage;

    private Parent root;
    private Scene scene;

    private AnchorPane anchorpane;
    public String user, pass;
    
    @FXML
private Tooltip toolTip = new Tooltip();
    
    @FXML
    private CheckBox checkpassword;

    @FXML
    private PasswordField password;


    @FXML
    private Button signbutton;

    @FXML
    private TextField username;

    @FXML
    void sign_up_action(ActionEvent event) throws IOException {
     user=username.getText();
     pass=password.getText();
       if (isMySQLXAMPPOnline()) {
	                    login(user, pass, event);
	                    
	                } else // else if the database is offline
	                {
	                  Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Database Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Permission denied, please contact the administrator");
                    alert.showAndWait();
           
	                }
       
        
         
    }
    
    public boolean isMySQLXAMPPOnline() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void login(String user, String pass,ActionEvent event) {
        try {
            if (!isMySQLXAMPPOnline()) {
     
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Database Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Permission denied, please contact the administrator");
                    alert.showAndWait();
                return;
            }
            
            // call the database class
           loginuser lu = new loginuser(user, pass);
lu.loginAuthentication(user, pass, event);
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    // this is how to see a password
  public void seepassword(ActionEvent event) {
    try {
        // Check if the checkbox is selected.
        if (checkpassword.isSelected()) {
            // Show password
         showPassword(password);
        } else {
            // Hide password
          hidePassword();
       
        
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
// this function serve to show password
  private void showPassword(PasswordField password) {
    Point2D p = password.localToScene(password.getBoundsInLocal().getMaxX(), password.getBoundsInLocal().getMaxY());
    toolTip.setText(password.getText());
    toolTip.show(password,
            p.getX() + password.getScene().getX() + password.getScene().getWindow().getX(),
            p.getY() + password.getScene().getY() + password.getScene().getWindow().getY());
   
}
  
  // this void serve to hide password
private void hidePassword() {
    toolTip.setText("");
    toolTip.hide();
    
   
}

   
}
