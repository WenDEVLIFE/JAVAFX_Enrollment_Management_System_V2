/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package signup;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class Sign_up_xmlController implements Initializable {

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password1;

    @FXML
    private Button signbutton;

    @FXML
    private TextField username;

    @FXML
    void sign_in_action(ActionEvent event) {
        // Add your logic for the sign-in action here
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Leave this method empty if you don't have specific initialization logic
    }
}
