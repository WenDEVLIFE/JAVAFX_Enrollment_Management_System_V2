/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package signup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafxapplication.Main;
import static javafxapplication.maincontroller.stage1;


/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class Sign_up_xmlController implements Initializable {
 public static Stage stage;
      private Parent root;
      private Scene scene;
      
  @FXML
public static AnchorPane anchorpane;
          
     @FXML
  public Button login_back;
     
         @FXML
    private CheckBox checkpassword;

      
    @FXML
    private PasswordField password1;

    @FXML
    private PasswordField confirmapssword;

    @FXML
    private Button signbutton;

    @FXML
    private TextField username;

    @FXML
    void sign_in_action(ActionEvent event) {
        // Add your logic for the sign-in action here
    }
      @FXML
void login_back(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/javafxapplication/mainfxml.fxml"));
    Scene scene = new Scene(root);
    Image icon = new Image(getClass().getResourceAsStream("/pictures/mabini.png"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.getIcons().add(icon);
    stage.setTitle("Login");
    stage.show();
 stage.setResizable(false);
    
}
   
 @FXML
   public  void seepassword(ActionEvent event) {
        try {
        // Check if the checkbox is selected.
        if (checkpassword.isSelected()) {
            // Show password
            password1.setPromptText(password1.getText());
             confirmapssword.setPromptText( confirmapssword.getText());
              password1.setText("");
              confirmapssword.setText("");

        } else {
            // Hide password
            password1.setText(password1.getPromptText());
                       
            confirmapssword.setText( confirmapssword.getPromptText());
                      
        
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Leave this method empty if you don't have specific initialization logic
    }
}
