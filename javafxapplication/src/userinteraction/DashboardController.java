/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userinteraction;

import functions.User_Exist;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;

public class DashboardController {

    public String user;
    
    public static String password;
    public static String confirmpass;
    

@FXML
private Tooltip toolTip = new Tooltip();
private Tooltip toolTip1 = new Tooltip();


  public DashboardController() {
        // Initialize the tooltip
        this.toolTip = new Tooltip();
          this.toolTip1 = new Tooltip();
    }
    
    // this are the tabs
    @FXML
    private Tab DASHB;

    @FXML
    private Tab Enroll;

    @FXML
    private Tab EnrollTableForm;
    
       @FXML
    private Tab Grading;

    @FXML
    private Tab Report;

       @FXML
    private Tab Subject;
       
       @FXML
    private Tab User;
    
        @FXML
    private Tab CreateGrades;
               
        @FXML
    private Tab Admin;

               
    @FXML
       
        // my tabpane
    private TabPane TabPanesel;
        
    @FXML
    private Button Enrollaction;

    @FXML
    private Button dashboards;

    @FXML
    private Button gradesbuttonaction;

    @FXML
    private Button reportbutton;

    @FXML
    private Pane tabbedpanemenu;
    
    
        @FXML
    private Label userlabel;
        
    // table
    @FXML
    private TableView<?> EnrollTable;
    
    
    // combolist
    @FXML
    private ComboBox<String> selecttable;
      @FXML
     private ComboBox<String> selecttable1;
      
        @FXML
    private ComboBox<String> selecttable2;

    @FXML
    private ComboBox<String> selecttable3;

    @FXML
    private ComboBox<String> selecttable4;
    
    
    @FXML
    private ComboBox<String> selecttable5;

    @FXML
    private ComboBox<String> selecttable6;
    
        @FXML
    private TextField usernamefield;
        
            @FXML
    private PasswordField passwordfield;
            
    @FXML
    private  PasswordField confirmpasswordfield;
    
        @FXML
    private ComboBox<String> Role;
        
            @FXML
    private CheckBox checkpassword;
        
              @FXML
    public void initialize() {
            userlabel.setText("Username:"+user);
        passwordfield.setTooltip(toolTip);
    confirmpasswordfield.setTooltip(toolTip1);
    
       selecttable.setValue("Select an Option");
       selecttable1.setValue("Select an Option");
       selecttable2.setValue("Select an Option");
       selecttable3.setValue("Select an Option");
       selecttable4.setValue("Select an Option");
          selecttable5.setValue("Select an Option");
             selecttable6.setValue("Select an Option");
        Role.setValue("Select an Role");
       
        // Add items to the ComboBox
        ObservableList<String> items = FXCollections.observableArrayList(
                "Select an option",
                "Enrollment Form",
                "Enrollment Table"
                // Add more items as needed
        );

        selecttable1.setItems(items);
    
          selecttable.setItems(items);
          
          
            ObservableList<String> items1 = FXCollections.observableArrayList(
                "Select an option",
                "User Table",
                "Add User Form"
                // Add more items as needed
        );
          selecttable2.setItems(items1);
          selecttable3.setItems(items1);

            ObservableList<String> items2 = FXCollections.observableArrayList(
                "Select an option",
                "Subject Table",
                "Grading System form",
                "Grade result form",
                "Create Subject"
                // Add more items as needed
        );
     
             selecttable4.setItems(items2);
             selecttable5.setItems(items2);
             selecttable6.setItems(items2);
             
                ObservableList<String> items3 = FXCollections.observableArrayList(
                "Select an Role",
                "Admin",
                "Teacher"
                // Add more items as needed
        );
                  Role.setItems(items3);
}
    
    
    // this are the action events
    
    
      @FXML
     void AdduserAction(ActionEvent event) {
         String username = usernamefield.getText();
        password = passwordfield.getText();
        confirmpass = confirmpasswordfield.getText();
        String selectedItemString1 = Role.getSelectionModel().getSelectedItem();

        if (selectedItemString1.equals("Select an Role")) {
            showAlert("Please select a role.");
        } else {
            if (username.isEmpty() || password.isEmpty() || confirmpass.isEmpty()) {
                showAlert("Don't leave a field blank. Please fill in all fields.");
            } else if (!password.equals(confirmpass)) {
                showAlert("Passwords do not match!");
            } else if (!verifyPasswordLength(confirmpass)) {
                showAlert("Password must be at least 8 to 12 characters long.");
            } else {
                boolean hasCapsLock = false;
                boolean hasSpecialCharacters = false;

                for (char character : confirmpass.toCharArray()) {
                    if (Character.isUpperCase(character)) {
                        hasCapsLock = true;
                    } else if (!Character.isLetterOrDigit(character)) {
                        hasSpecialCharacters = true;
                    }
                }

                if (!hasCapsLock || !hasSpecialCharacters) {
                    showAlert("The password must contain at least one uppercase letter and one special character.");
                } else {
                    // All checks passed, user registration or other actions can proceed here
                  User_Exist e = new User_Exist(username, password, selectedItemString1);
                    e.user_identification();
                    clearFields(); // You can define this method to clear the input fields
                }
            }
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean verifyPasswordLength(String password) {
         int length = password.length();
    return length >= 8 && length <=20;
    }

    private void clearFields() {
        // Implement your logic to clear the input fields here
        usernamefield.clear();
        passwordfield.clear();
        confirmpasswordfield.clear();
        Role.getSelectionModel().clearSelection();
    }
    
       // this is how to see a password
  public void seepassword(ActionEvent event) {
       password = passwordfield.getText();
        confirmpass = confirmpasswordfield.getText();
    try {
        // Check if the checkbox is selected.
        if (checkpassword.isSelected()) {
            // Show password
           showPassword(passwordfield);
           showPassword1(confirmpasswordfield);
        } else {
           hidePassword();
        
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
  
  // this function serve to show password
  private void showPassword(PasswordField passwordfield) {
    Point2D p = passwordfield.localToScene(passwordfield.getBoundsInLocal().getMaxX(), passwordfield.getBoundsInLocal().getMaxY());
    toolTip.setText(passwordfield.getText());
    toolTip.show(passwordfield,
            p.getX() + passwordfield.getScene().getX() + passwordfield.getScene().getWindow().getX(),
            p.getY() + passwordfield.getScene().getY() + passwordfield.getScene().getWindow().getY());
   
}
  private void showPassword1( PasswordField confirmpasswordfield) {
  
    // this is for confirmpasswordfield
    Point2D p1 = confirmpasswordfield.localToScene(confirmpasswordfield.getBoundsInLocal().getMaxX(), confirmpasswordfield.getBoundsInLocal().getMaxY());
    toolTip1.setText(confirmpasswordfield.getText());
    toolTip1.show(confirmpasswordfield,
            p1.getX() + confirmpasswordfield.getScene().getX() + confirmpasswordfield.getScene().getWindow().getX(),
            p1.getY() + confirmpasswordfield.getScene().getY() + confirmpasswordfield.getScene().getWindow().getY());
}

  // this void serve to hide password
private void hidePassword() {
    toolTip.setText("");
    toolTip.hide();
    
      toolTip1.setText("");
    toolTip1.hide();
}
   @FXML
    void comboaction(ActionEvent event) {
        String selectedItem = selecttable.getSelectionModel().getSelectedItem();

        // Check the selected item and switch to the corresponding tab
        if (selectedItem.equals("Enrollment Form")) {
   TabPanesel.getSelectionModel().select(Enroll);
        } else if (selectedItem.equals("Enrollment Table")) {
  TabPanesel.getSelectionModel().select(EnrollTableForm);
        }
        // Add more conditions as needed for other strings or tabs
    }
     
       @FXML
    void comboshitacctionfucker(ActionEvent event) {

        String selectedItem1 = selecttable1.getSelectionModel().getSelectedItem();

            // Check the selected item and switch to the corresponding tab
        if (selectedItem1.equals("Enrollment Form")) {
   TabPanesel.getSelectionModel().select(Enroll);
        } else if (selectedItem1.equals("Enrollment Table")) {
  TabPanesel.getSelectionModel().select(EnrollTableForm);
        }
        // Add more conditions as needed for other strings or tabs
    }
    
    @FXML
    void comboaction2(ActionEvent event) {
      String selectedItem2 = selecttable2.getSelectionModel().getSelectedItem();

        // Check the selected item and switch to the corresponding tab
             if (selectedItem2.equals("User Table")) {
TabPanesel.getSelectionModel().select(Admin);
        } else if (selectedItem2.equals("Add User Form")) {
  TabPanesel.getSelectionModel().select(User);
        }
        // Add more conditions as needed for other strings or tabs
    
    }
        @FXML
    void comboaction3(ActionEvent event) {
   String selectedItem2 = selecttable3.getSelectionModel().getSelectedItem();

        // Check the selected item and switch to the corresponding tab
        if (selectedItem2.equals("User Table")) {
TabPanesel.getSelectionModel().select(Admin);
        } else if (selectedItem2.equals("Add User Form")) {
  TabPanesel.getSelectionModel().select(User);
        }
    }

    @FXML
    void comboaction4(ActionEvent event) {

         String selectedItem3 = selecttable4.getSelectionModel().getSelectedItem();

        // Check the selected item and switch to the corresponding tab
        if (selectedItem3.equals("Subject Table")) {
TabPanesel.getSelectionModel().select(Subject);
        } else if (selectedItem3.equals("Grading System form")) {
  TabPanesel.getSelectionModel().select(CreateGrades);
        } else if (selectedItem3.equals("Grade result form")) {
  TabPanesel.getSelectionModel().select(Grading);
        }
        else if (selectedItem3.equals("Create Subject")) {
  TabPanesel.getSelectionModel().select(User);
        }
    
    }
    
    
    @FXML
    void comboaction5(ActionEvent event) {
    String selectedItem3 = selecttable5.getSelectionModel().getSelectedItem();

        // Check the selected item and switch to the corresponding tab
        if (selectedItem3.equals("Subject Table")) {
TabPanesel.getSelectionModel().select(Subject);
        } else if (selectedItem3.equals("Grading System form")) {
  TabPanesel.getSelectionModel().select(CreateGrades);
        } else if (selectedItem3.equals("Grade result form")) {
  TabPanesel.getSelectionModel().select(Grading);
        }
        else if (selectedItem3.equals("Create Subject")) {
  TabPanesel.getSelectionModel().select(User);
        }
    }

    @FXML
    void comboaction6(ActionEvent event) {

            String selectedItem3 = selecttable6.getSelectionModel().getSelectedItem();

        // Check the selected item and switch to the corresponding tab
        if (selectedItem3.equals("Subject Table")) {
TabPanesel.getSelectionModel().select(Subject);
        } else if (selectedItem3.equals("Grading System form")) {
  TabPanesel.getSelectionModel().select(CreateGrades);
        } else if (selectedItem3.equals("Grade result form")) {
  TabPanesel.getSelectionModel().select(Grading);
        }
        else if (selectedItem3.equals("Create Subject")) {
  TabPanesel.getSelectionModel().select(User);
        }
    }
    
    
    
    @FXML
    void Enroll_Action(ActionEvent event) {
TabPanesel.getSelectionModel().select(Enroll);
    }  
    @FXML
    void dashboard_Action(ActionEvent event) {
TabPanesel.getSelectionModel().select(DASHB);
    }
   @FXML
    void grades_Action(ActionEvent event) {
   TabPanesel.getSelectionModel().select(Subject);
    }

     @FXML
    void report_actionnotafuckingmousevent(ActionEvent event) {
   TabPanesel.getSelectionModel().select(Report);
    }

        @FXML
    void admin_action(ActionEvent event) {
   TabPanesel.getSelectionModel().select(Admin);
    }
    
public void setuserlabel(String user){
    userlabel.setText("Username:"+user);
}
    
}