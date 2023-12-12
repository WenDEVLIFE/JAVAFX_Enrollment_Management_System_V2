/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userinteraction;

import functions.CreateStudent;
import functions.DeleteInformationDB;
import functions.Student;
import functions.User;
import functions.User_Exist;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DashboardController {

    
    private static ObservableList<User> userList;
   ObservableList<Student> studentList = FXCollections.observableArrayList();
     public String jdbcUrl = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
       public   String username1 = "root";
        public   String password1 = "";
    private WeakReference<Button> buttonRef;
    
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

      @FXML
    private Label setLabelUser9;
    
    public static String password;
    public static String confirmpass;
    

@FXML
private Tooltip toolTip = new Tooltip();
private Tooltip toolTip1 = new Tooltip();


    @FXML
    private ImageView LogoView;

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
    private Tab CreateSubject;
      
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
    private Button clearbutton1;
        
         @FXML
    private Button enrollstudent;
         
             @FXML
    private Button clearbutton2;
             
    @FXML
    private Pane tabbedpanemenu;
    
        @FXML
    private ComboBox<String> Age;
        
        @FXML
    private ComboBox<String> day;
        
            @FXML
    private ComboBox<String> year;
            
            
    @FXML
    private ComboBox<String> month;

    
    @FXML
    private ComboBox<String> gender;
    // table
    @FXML
    private TableView<Student> EnrollTable;
    
    
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
    private ComboBox<String> selecttable7;
    
    @FXML
    private ComboBox<String> Role;
    
    
        @FXML
    private TextField usernamefield;
                
            @FXML
    private PasswordField passwordfield;
            
    @FXML
    private  PasswordField confirmpasswordfield;
        
        
    @FXML
    private TextField phonenumber;
    
        @FXML
    private TextField Address;
        
            @FXML
    private TextField Studentname;
            
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
    private MenuButton menuactions9;
              @FXML
    public void initialize() {
  
        // for the passwordfield and confirmpasswordfield
        passwordfield.setTooltip(toolTip);
    confirmpasswordfield.setTooltip(toolTip1);
    
    // set value for the combobox
       selecttable.setValue("Select an Option");
       selecttable1.setValue("Select an Option");
       selecttable2.setValue("Select an Option");
       selecttable3.setValue("Select an Option");
       selecttable4.setValue("Select an Option");
       selecttable5.setValue("Select an Option");
       selecttable6.setValue("Select an Option");
       selecttable7.setValue("Select an Option");
       Role.setValue("Select an Role");
       Age.setValue("Select age");
       year.setValue("Select a year");
       gender.setValue("Select a gender");
        month.setValue("Select a month");       

        // This are the assigned vale for comboBox
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
               selecttable7.setItems(items2);
               
                   ObservableList<String> items4 = FXCollections.observableArrayList(
                "Select age"
                // Add more items as needed
        );
                    for (int i = 1; i <= 50; i++) {
            items4.add(String.valueOf(i));
        }
                Age.setItems(items4);
                    
                
                    ObservableList<String> items5 = FXCollections.observableArrayList(
                "Select gender",
                "Male" ,"Female"
                // Add more items as needed
        );
                        gender.setItems(items5);
                      
                   ObservableList<String> items6 = FXCollections.observableArrayList(
                "Select a month",
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
             
                   month.setItems(items6);
                   
                        ObservableList<String> items7 = FXCollections.observableArrayList(
                "Select a day"
              
        );
             
                    for (int i = 1; i <= 31; i++) {
            items7.add(String.valueOf(i));
        }
                    day.setItems(items7);
                    
                     ObservableList<String> items8 = FXCollections.observableArrayList(
                "Select a day"
              
        );
               int startYear = 1990;
        int endYear = 2024;
                    for (int year = startYear; year <= endYear; year++) {
            items8.add(String.valueOf(year));
        }
                     year.setItems(items8);
                   
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

       Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Delete Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("Are you sure you want to Delete this user?");

    // Add "Yes" and "No" buttons
    ButtonType buttonTypeYes = new ButtonType("Yes");
    ButtonType buttonTypeNo = new ButtonType("No");

    alert.showAndWait().ifPresent((ButtonType response) -> {
        if (response == buttonTypeYes) {
            // Get the selected item
            User selectedUser = AdminTable.getSelectionModel().getSelectedItem();

            if (selectedUser != null) {
                // Delete the user from the database
                DeleteInformationDB db = new DeleteInformationDB();
                db.deleteuser(selectedUser);

                // Remove the selected user from the TableView
                AdminTable.getItems().remove(selectedUser);
            }
        } else if (response == buttonTypeNo) {
            // User clicked "No," do nothing or handle accordingly
        }
    });
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
        deleteColumn.setCellFactory(param -> new ButtonCell("Delete", userList ));

        TableColumn<User, Void> editColumn = new TableColumn<>("Edit");
        editColumn.setCellFactory(param -> new ButtonCell("Edit", userList ));

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
        
        
       
    EnrollTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);          
    TableColumn<Student, Integer> idColumn1 = new TableColumn<>("ID");
        idColumn1.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        idColumn1.setCellFactory(CustomTableCellFactory1::cellFactoryForInteger);

TableColumn<Student, String> usernameColumn1 = new TableColumn<>("Name");
        usernameColumn1.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        usernameColumn1.setCellFactory(CustomTableCellFactory1::createCenteredStringCell);

usernameColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
usernameColumn1.setOnEditCommit(event -> {
    Student user1 = event.getRowValue();
     user1.setUsername(event.getNewValue());
  

    
});
TableColumn<Student, String> Agecolumn = new TableColumn<>("Age");
      Agecolumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        Agecolumn.setCellFactory(CustomTableCellFactory1::createCenteredStringCell);
         Agecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
         Agecolumn.setOnEditCommit(event -> {
 
});
      
TableColumn<Student, String> AddressColumn1 = new TableColumn<>("Address");
       AddressColumn1.setCellValueFactory(new PropertyValueFactory<>("StudentAddress"));
        AddressColumn1.setCellFactory(CustomTableCellFactory1::createCenteredStringCell);
         AddressColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
         AddressColumn1.setOnEditCommit(event -> {
 
});
         
         
        TableColumn<Student, String> Gendercolumn = new TableColumn<>("Gender");
       Gendercolumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        Gendercolumn.setCellFactory(CustomTableCellFactory1::createCenteredStringCell);
  Gendercolumn.setCellFactory(TextFieldTableCell.forTableColumn());
   Gendercolumn.setOnEditCommit(event -> {
 
});
  
          TableColumn<Student, String> Birthcolumn = new TableColumn<>("Born");
       Birthcolumn.setCellValueFactory(new PropertyValueFactory<>("BirthYear"));
       Birthcolumn .setCellFactory(CustomTableCellFactory1::createCenteredStringCell);
 Birthcolumn .setCellFactory(TextFieldTableCell.forTableColumn());
Birthcolumn .setOnEditCommit(event -> {
 
});
 
     TableColumn<Student, String> PhoneNumbercolumn = new TableColumn<>("Phone Number");
     PhoneNumbercolumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNum"));
       PhoneNumbercolumn .setCellFactory(CustomTableCellFactory1::createCenteredStringCell);
 PhoneNumbercolumn .setCellFactory(TextFieldTableCell.forTableColumn());
  PhoneNumbercolumn.setOnEditCommit(event -> {
 
});


        TableColumn<Student, Void> deleteColumn1 = new TableColumn<>("Delete");
        deleteColumn1.setCellFactory(param -> new ButtonCell1("Delete", studentList ));
        deleteColumn1.setOnEditCommit(event -> {
    Student selectedStudent = event.getRowValue();
    String studentName = selectedStudent.getStudentName();
    System.out.println("Clicked Edit for student: " + studentName);
           EnrollTable.getItems().remove( selectedStudent);
    // Add your logic to handle the Edit action for this student
});

        TableColumn<Student, Void> editColumn1 = new TableColumn<>("Edit");
        editColumn1.setCellFactory(param -> new ButtonCell1("Edit", studentList));
        editColumn1.setOnEditCommit(event -> {
    Student selectedStudent = event.getRowValue();
    String studentName = selectedStudent.getStudentName();
    System.out.println("Clicked Edit for student: " + studentName);

    // For example, you can create a method like editStudent(Student student) and call it here
    // This method would then handle opening the editing interface and updating the student details
    // You may also want to refresh the table after editing to reflect changes
});

        // Add columns to the table
        EnrollTable.getColumns().addAll(idColumn1, usernameColumn1, Agecolumn,AddressColumn1,Gendercolumn,PhoneNumbercolumn, Birthcolumn,deleteColumn1, editColumn1);

        
// Set column resize policy
   EnrollTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


// Autoresize columns
 EnrollTable.getColumns().forEach(column -> {
            if (column.isResizable()) {
                column.setPrefWidth(AdminTable.getWidth() / AdminTable.getColumns().size());
            }
        });
 
        enroll_loadDataFromDatabase();
               
              
                      
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
                     DatabaseHandler databaseHandler = new DatabaseHandler(jdbcUrl, username1, password1);
  
               userList = databaseHandler.fetchDataFromDatabase();

                  User_Exist e = new User_Exist(username, password, selectedItemString1, AdminTable, userList);
                    e.user_identification();
                    clearFields(); // You can define this method to clear the input fields
                }
            }
        }
    }
     // to clear the admin form
  @FXML
    void clearbuttonaction2(ActionEvent event) {
        usernamefield.setText("");
        passwordfield.setText("");
        confirmpasswordfield.setText("");
     Role.setValue("Select an Role");
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
     
    
    // this are ComboBox from enrollment tform to enroll 
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
TabPanesel.getSelectionModel().select(CreateSubject);
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
 TabPanesel.getSelectionModel().select(CreateSubject);
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
 TabPanesel.getSelectionModel().select(CreateSubject);
        }
    }
    
    // to enroll student function
     @FXML
    void EnrollStudent(ActionEvent event) throws SQLException, ClassNotFoundException {
         String studentname = Studentname.getText();
         String address = Address.getText();
         String Phone = phonenumber.getText();
         String selected_Age = Age.getSelectionModel().getSelectedItem();
         String selected_gender = gender.getSelectionModel().getSelectedItem();
         String birthmonth = month.getSelectionModel().getSelectedItem();
         String birthdate = day.getSelectionModel().getSelectedItem();
         String birthyear = year.getSelectionModel().getSelectedItem();
          if(studentname.isEmpty() || Phone.isEmpty() || address.isEmpty()){
              Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("System Message");
        alert.setHeaderText(null);
        alert.setContentText("Please fill all the blanks");
        alert.showAndWait();
          }
          else {
              if(selected_Age=="Select age" || selected_gender=="Select gender" || birthmonth=="Select a month" || birthdate =="Select a day" || birthyear =="Select a year"){
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("System Message");
        alert.setHeaderText(null);
        alert.setContentText("Please select a value from the Age, month, day and year");
        alert.showAndWait();
              } else {
                  if (isValidPhoneNumber(Phone)) {
                          Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("System Message");
        alert.setHeaderText(null);
        alert.setContentText("The phone number lenght should be 11");
        alert.showAndWait();
                  }
                  else {
                  CreateStudent s = new CreateStudent(studentname, address, Phone, selected_Age, selected_gender ,birthmonth, birthdate, birthyear ,EnrollTable, studentList);
                  s.createstudent();
                  }
              }
          }
         
    }
    
    // to clear the enrollment form
      @FXML
    void clearbuttonaction1(ActionEvent event) {
 Studentname.setText("");       
 Address.setText("");    
 phonenumber.setText("");       
Age.setValue("Select age");
year.setValue("Select a year"); 
gender.setValue("Select a gender"); 
month.setValue("Select a month");
    }
    
    // for sidepanel navbar function
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
       setLabelUser9.setText("User:" + user);
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
    javafx.scene.image.Image icon2 = new javafx.scene.image.Image(getClass().getResourceAsStream("/pictures/mabini.png"));
    loginStage.getIcons().add(icon2);

    loginStage.setScene(new Scene(root));
   icon2 = null;
    // Close the current stage
    if (stage1 != null) {
        stage1.close();
        memoryleakclose();
    } else {
        System.out.println("Error: stage1 is null");
    }

    // Show the login stage
    loginStage.show();
}

    private void loadDataFromDatabase() {
    // Clear existing data in the table
        AdminTable.getItems().clear();


        // call the class to display the value from the database
        DatabaseHandler databaseHandler = new DatabaseHandler(jdbcUrl, username1, password1);
    try {
    // Fetch data from the database
 userList = databaseHandler.fetchDataFromDatabase();
    // Set the items in the TableView
    AdminTable.setItems(userList);
} finally {
    // Close the database connection
    databaseHandler.closeConnection();
}
    }
    private void enroll_loadDataFromDatabase() {
    // Clear existing data in the table
        EnrollTable.getItems().clear();


        // call the class to display the value from the database
        DatabaseHandler databaseHandler = new DatabaseHandler(jdbcUrl, username1, password1);
    try {
    // Fetch data from the database
 studentList = databaseHandler.fetchDataFromDatabase1();
    // Set the items in the TableView
  EnrollTable.setItems(studentList);
} finally {
    // Close the database connection
    databaseHandler.closeConnection();
}
    }
    
    // disable Components when not used
   public void memoryleakclose(){
     Tab selectedTab = TabPanesel.getSelectionModel().getSelectedItem();
    if (selectedTab != null) {
         MemoryManagement m= new MemoryManagement(Enrollaction, dashboards, gradesbuttonaction, reportbutton,
            tabbedpanemenu,
            EnrollTable, AdminTable,
            selecttable, selecttable1,
            selecttable2, selecttable3,
            selecttable4, selecttable5,
            selecttable6, Role,
            menuactions, menuactions1,
            menuactions2, menuactions3,
            menuactions4, menuactions5,
            menuactions6, menuactions7,
            menuactions8,  menuactions9);
     m.disableLeaks();
     LogoView = null;
      TabPanesel.getTabs().remove(selectedTab);
    }

    }
    private static boolean isValidPhoneNumber(String Phone){
         return Phone.matches("0\\d{10}");
    }
}