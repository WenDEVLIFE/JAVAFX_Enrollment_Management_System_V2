/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinteraction;

/**
 *
 * @author Administrator
 */
import com.javafx.functions.Subject;
import com.javafx.functions.DeleteInformationDB;
import com.javafx.functions.Grading;
import com.javafx.functions.Print_Grades;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ButtonCell2 extends TableCell<Subject, Void> {

    private final Button button;
    private final ObservableList<Subject> subjectList;
    private final TableView<Grading> GradingTable;
    private String subjectname; 
    private  String subjectName;
    private String subject_Receiver;
    private final TextField getsubjectname;
    
    // Receive the value of this from dashboard controller
    private TabPane TabPanesel;
    private Tab Grading1;
    private Label SubjectName;
      private String user1;
    public ButtonCell2(String buttonText, ObservableList<Subject> subjectList, TableView<Grading> GradingTable, TabPane TabPanesel, Tab Grading1, Label SubjectName, String user1, String subjectname, TextField getsubjectname) {
        this.button = new Button(buttonText);
        this.subjectList = subjectList;
        this.GradingTable = GradingTable;
        this.TabPanesel = TabPanesel;
        this.Grading1 = Grading1 ;
        this.SubjectName = SubjectName;
        this.user1 = user1;
        this.getsubjectname = getsubjectname;
        



        this.button.setOnAction(event -> {
            Subject selectedSubject = getTableRow().getItem();
             subjectName = selectedSubject.getSubjectName();
            if (selectedSubject != null) {
                if (buttonText.equals("Delete")) {
               
                    // Code for deleting subject
                    handleDeleteSubject(selectedSubject);
                } else if (buttonText.equals("Open")) {
                    try {
                        // Code for opening grading tab

                        handleOpenGradingTab(selectedSubject,subject_Receiver);
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonCell2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
            }
        });
    }

    private void handleDeleteSubject(Subject selectedSubject) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation");
          String iconPath = "pictures/deleteicon.png";
                    // Load the PNG image
                    Image iconImage = new Image(iconPath);

                    ImageView imageView = new ImageView(iconImage);
                    imageView.setFitWidth(64);
                    imageView.setFitHeight(64);
                    alert.getDialogPane().setGraphic(imageView);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this subject?");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        alert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeYes) {
                DeleteInformationDB db = new DeleteInformationDB();
                db.deletesubject(selectedSubject,user1);

                // Remove the subject from the table and database
                subjectList.remove(selectedSubject);
                System.gc();
            }
        });
    }

    // this will open and go to next tab
    private void handleOpenGradingTab(Subject selectedSubject, String subject_Receiver) throws IOException {
        System.out.println("Open subject");
        TabPanesel.getSelectionModel().select(Grading1 );
getsubjectname.setText(""+subjectName);
         SubjectName.setText("Subject Name:"+subjectName);
                   this.subjectname = subjectName; 
                   System.out.println("SubjectName:"+subjectname );
                   
                      // Set the subject_Receiver value here
            subject_Receiver = subjectName;
            System.out.println("The value of subject receiver: " + subject_Receiver);
        // Fetch grading information based on the selected subject
        SubjectDatabase subjectDatabase = new SubjectDatabase();
        List<Grading> gradingList = subjectDatabase.getGradingBySubjectName(selectedSubject.getSubjectName());

        // Update the TableView with the fetched details
        GradingTable.getItems().clear();
        GradingTable.getItems().addAll(gradingList);

        System.out.println("Subject Name: " + selectedSubject.getSubjectName());
        System.out.println("Grading List: " + gradingList);
     
    }

    @Override
   protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            // Set style class for the button based on buttonText
            String buttonText = getButton().getText();
            if ("Delete".equals(buttonText)) {
                button.getStyleClass().setAll("custom-button-cell2-delete");
            } else if ("Open".equals(buttonText)) {
                button.getStyleClass().setAll("custom-button-cell2-open");
            }

            setGraphic(button);
        }
    }
public Button getButton() {
        return button;
    }
}
