/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinteraction;

/**
 *
 * @author Administrator
 */
import com.javafx.functions.DeleteInformationDB;
import com.javafx.functions.Student;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class ButtonCell1 extends TableCell<Student, Void> {
    private final Button button;
    private final ObservableList<Student> studentList;
    private String user1;
    public ButtonCell1(String buttonText, ObservableList<Student> studentList, TabPane TabPanesel, Tab changestudentinformation, String user1) {
        this.button = new Button(buttonText);
        this.studentList = studentList;
        this.user1 = user1;

        this.button.setOnAction(event -> {
              Student selectedStudent = getTableRow().getItem();
            if (selectedStudent != null) {
                if (buttonText.equals("Delete")) {
                    // Code for deleting user
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to delete this user?");

                    ButtonType buttonTypeYes = new ButtonType("Yes");
                    ButtonType buttonTypeNo = new ButtonType("No");

                    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                    alert.showAndWait().ifPresent(response -> {
                        if (response == buttonTypeYes) {
                            System.out.println(selectedStudent);
                                DeleteInformationDB db = new DeleteInformationDB();
                                db.deleteStudent(selectedStudent,user1);
                                
                                // remove the student from the table and to the database
                                    studentList.remove(selectedStudent);
                           
                                           System.gc();
                        }
                    });
                } else if (buttonText.equals("Edit")) {
                    
                               TabPanesel.getSelectionModel().select(changestudentinformation);
                }
            }
        });
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
            } else if ("Edit".equals(buttonText)) {
                button.getStyleClass().setAll("custom-button-cell2-open");
            }

            setGraphic(button);
        }
    }
public Button getButton() {
        return button;
    }
}
