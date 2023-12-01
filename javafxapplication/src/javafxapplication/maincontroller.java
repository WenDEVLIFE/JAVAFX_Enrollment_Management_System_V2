/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class maincontroller {
      private Stage primaryStage;
    private Scene scene2;

    @FXML
    private PasswordField password;

    @FXML
    private Label labels;

    @FXML
    private Button signbutton;

    @FXML
    private TextField username;

    @FXML
    void sign_up_action(ActionEvent event) {
        System.out.println("Hello World");
    }

    
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    @FXML
void handleLabelClick(MouseEvent event) {
  try {
            Main.showSignup((Stage) labels.getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    
}

   
}
