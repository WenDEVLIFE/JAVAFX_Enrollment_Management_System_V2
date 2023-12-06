/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userinteraction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class DashboardController {

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
    public void initialize() {
       selecttable.setValue("Select an Option");
       selecttable1.setValue("Select an Option");
       selecttable2.setValue("Select an Option");
       selecttable3.setValue("Select an Option");
       selecttable4.setValue("Select an Option");
       
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
}
    
    // this are the action events
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
    

}