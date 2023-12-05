/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static signup.Sign_up_xmlController.stage;


public class maincontroller {
    public static Stage stage1, stage2;

    private Parent root;
    private Scene scene;

    private AnchorPane anchorpane;
    public static String u, p;
    @FXML
    private CheckBox checkpassword;

    @FXML
    private PasswordField password;

    @FXML
    private Label labels;

    @FXML
    private Button signbutton;

    @FXML
    private TextField username;

    @FXML
    void sign_up_action(ActionEvent event) throws IOException {
     u=username.getText();
     p=password.getText();
     
           Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("userinteraction/dashboard.fxml"));
            Scene scene = new Scene(root);
            Image icon = new Image(getClass().getResourceAsStream("/pictures/mabini.png"));
            stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage2.setScene(scene);
            stage2.getIcons().add(icon);
            stage2.setTitle("Mabini National High School Management System Dashboard");
            stage2.show();
            stage2.setResizable(false);
    }
    @FXML
    // this is how to see a password
  public void seepassword(ActionEvent event) {
    try {
        // Check if the checkbox is selected.
        if (checkpassword.isSelected()) {
            // Show password
            password.setPromptText(password.getText());
            password.setText(p);
        } else {
            // Hide password
            password.setText(password.getPromptText());
       
        
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @FXML
    void handleLabelClick(MouseEvent event) throws IOException {
        // this is how you change scenes
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("signup/sign_up_xml.fxml"));
            Scene scene = new Scene(root);
            Image icon = new Image(getClass().getResourceAsStream("/pictures/mabini.png"));
            stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage1.setScene(scene);
            stage1.getIcons().add(icon);
            stage1.setTitle("Login");
            stage1.show();
            stage1.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
}
