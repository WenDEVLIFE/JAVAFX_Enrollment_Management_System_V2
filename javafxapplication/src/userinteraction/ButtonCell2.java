/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinteraction;

/**
 *
 * @author Administrator
 */
import functions.Subject;
import functions.DeleteInformationDB;
import functions.Grading;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;


public class ButtonCell2 extends TableCell<Subject, Void> {

    private final Button button;
    private final ObservableList<Subject> subjectList;
    private final TableView<Grading> GradingTable;
    
    // Receive the value of this from dashboard controller
    private TabPane TabPanesel;
    private Tab Grading1;
    private Label SubjectName;

    public ButtonCell2(String buttonText, ObservableList<Subject> subjectList, TableView<Grading> GradingTable, TabPane TabPanesel, Tab Grading1, Label SubjectName) {
        this.button = new Button(buttonText);
        this.subjectList = subjectList;
        this.GradingTable = GradingTable;
        this.TabPanesel = TabPanesel;
        this.Grading1 = Grading1 ;
        this.SubjectName = SubjectName;

        this.button.setOnAction(event -> {
            Subject selectedSubject = getTableRow().getItem();
            String subjectName = selectedSubject.getSubjectName();
            if (selectedSubject != null) {
                if (buttonText.equals("Delete")) {
                    // Code for deleting subject
                    handleDeleteSubject(selectedSubject);
                } else if (buttonText.equals("Open")) {
                    // Code for opening grading tab
                    handleOpenGradingTab(selectedSubject);
                    SubjectName.setText("Subject Name:"+subjectName);
                }
            }
        });
    }

    private void handleDeleteSubject(Subject selectedSubject) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this subject?");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        alert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeYes) {
                DeleteInformationDB db = new DeleteInformationDB();
                db.deletesubject(selectedSubject);

                // Remove the subject from the table and database
                subjectList.remove(selectedSubject);
                System.gc();
            }
        });
    }

    // this will open and go to next tab
    private void handleOpenGradingTab(Subject selectedSubject) {
        System.out.println("Open subject");
        TabPanesel.getSelectionModel().select(Grading1 );

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
            setGraphic(button);
        }
    }
}
