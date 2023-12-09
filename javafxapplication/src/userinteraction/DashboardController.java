/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userinteraction;

import functions.User;
import functions.User_Exist;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class DashboardController {

         private Stage stage1;
    // for receiving the username and display it on the label
       @FXML
    private Label setLabelUser;

      @FXML
    private Label setLabelUser1;

    @FXML
    private Label setLabelUser2;

    @FXML
    private Label setLabelUser3;

    @FXML
    private Label setLabelUser4;

    @FXML
    private Label setLabelUser5;

    @FXML
    private Label setLabelUser6;
    
        @FXML
    private Label setUserLabel7;

    @FXML
    private Label setUserLabel8;

    
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
  
  
    public void setStage(Stage stage1) {
        this.stage1 = stage1;
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
    
        
    // table
    @FXML
    private TableView<?> EnrollTable;
    
    
    @FXML
    private TableView<User> AdminTable;
    
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
        
            // for menu action
      @FXML
    private MenuButton menuactions;

    @FXML
    private MenuButton menuactions1;

    @FXML
    private MenuButton menuactions2;

    @FXML
    private MenuButton menuactions3;

    @FXML
    private MenuButton menuactions4;

    @FXML
    private MenuButton menuactions5;

    @FXML
    private MenuButton menuactions6;

    @FXML
    private MenuButton menuactions7;       
    
    @FXML
    private MenuButton menuactions8;
            
              @FXML
    public void initialize() {
        // for the passwordfield and confirmpasswordfield
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
                  
        AdminTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);          
    TableColumn<User, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setCellFactory(CustomTableCellFactory::cellFactoryForInteger);

TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        usernameColumn.setCellFactory(CustomTableCellFactory::createCenteredStringCell);

usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
usernameColumn.setOnEditCommit(event -> {
    User user = event.getRowValue();
    user.setUsername(event.getNewValue());
    // Handle database update or other logic
});

TableColumn<User, String> roleColumn = new TableColumn<>("Role");
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        roleColumn.setCellFactory(CustomTableCellFactory::createCenteredStringCell);
roleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
roleColumn.setOnEditCommit(event -> {
    User user = event.getRowValue();
    user.setRole(event.getNewValue());
    // Handle database update or other logic
});

        TableColumn<User, Void> deleteColumn = new TableColumn<>("Delete");
        deleteColumn.setCellFactory(param -> new ButtonCell("Delete"));

        TableColumn<User, Void> editColumn = new TableColumn<>("Edit");
        editColumn.setCellFactory(param -> new ButtonCell("Edit"));

        // Add columns to the table
        AdminTable.getColumns().addAll(idColumn, usernameColumn, roleColumn, deleteColumn, editColumn);

// Set column resize policy
AdminTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

// Autoresize columns
AdminTable.getColumns().forEach(column -> {
    if (column.isResizable()) {
        column.setPrefWidth(AdminTable.getWidth() / AdminTable.getColumns().size());
    }
});

        // Load data from the database
        loadDataFromDatabase();
    
                  
                  
                      
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

// for sidepanel navbar function buttons
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

if ( setLabelUser != null ||  setLabelUser1 !=null  ||  setLabelUser2 !=null ||  setLabelUser2 !=null ){
   setLabelUser.setText("User:"+ user);
    setLabelUser1.setText("User:" + user);
    setLabelUser2.setText("User:" + user);
    setLabelUser3.setText("User:" + user);
    setLabelUser4.setText("User:" + user);
    setLabelUser5.setText("User:" + user);
    setLabelUser6.setText("User:" + user);
     setUserLabel7.setText("User:" + user);
     setUserLabel8.setText("User:" + user);
  }
else {
    System.out.println("username is null");
}
} 
    

    @FXML
    void logoutaction(ActionEvent event) {
showLogoutConfirmation();
    }
    
    private void showLogoutConfirmation() {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Logout Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("Are you sure you want to logout?");

    // Add "Yes" and "No" buttons
    ButtonType buttonTypeYes = new ButtonType("Yes");
    ButtonType buttonTypeNo = new ButtonType("No");

    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

    // Show and wait for user's response
   alert.showAndWait().ifPresent((ButtonType response) -> {
    if (response == buttonTypeYes) {
        try {
            performLogout();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
            } else if (response == buttonTypeNo) {
                // User clicked "No," do nothing or handle accordingly
            }
        });
}

private void performLogout() throws IOException {
    System.out.println("Logging out...");

    // User clicked "Yes," perform logout action
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxapplication/mainfxml.fxml"));
    Parent root = loader.load();

    // Set up the stage for the new scene
    Stage loginStage = new Stage();
    loginStage.setTitle("Mabini National HighSchool Management System Login");

    // Set the icon for the login stage
    javafx.scene.image.Image icon = new javafx.scene.image.Image(getClass().getResourceAsStream("/pictures/mabini.png"));
    loginStage.getIcons().add(icon);

    loginStage.setScene(new Scene(root));

    // Close the current stage
    if (stage1 != null) {
        stage1.close();
    } else {
        System.out.println("Error: stage1 is null");
    }

    // Show the login stage
    loginStage.show();
}

    private void loadDataFromDatabase() {
    // Clear existing data in the table
        AdminTable.getItems().clear();

        // Replace these with your database connection details
        String jdbcUrl = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
        String username1 = "root";
        String password = "";

        // call the class to display the value from the database
        DatabaseHandler databaseHandler = new DatabaseHandler(jdbcUrl, username1, password);
        ObservableList<User> userList = databaseHandler.fetchDataFromDatabase();

        // Set the items in the TableView
        AdminTable.setItems(userList);
    }
    
    
 

    
}