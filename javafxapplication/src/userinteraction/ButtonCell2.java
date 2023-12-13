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
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.collections.ObservableList;

public class ButtonCell2 extends TableCell<Subject, Void> {
    private final Button button;
    private final ObservableList<Subject> subjectList;
    
    public ButtonCell2(String buttonText, ObservableList<Subject> subjectList) {
        this.button = new Button(buttonText);
        this.subjectList = subjectList;

        this.button.setOnAction(event -> {
              Subject selectedSubject = getTableRow().getItem();
            if (selectedSubject != null) {
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
                            System.out.println(selectedSubject);
                                DeleteInformationDB db = new DeleteInformationDB();
                                db.deletesubject(selectedSubject);
                                
                                // remove the student from the table and to the database
                                    subjectList.remove(selectedSubject);
                                           System.gc();
                           
                        }
                    });
                } else if (buttonText.equals("Open")) {
                      System.out.println("Open subject");
                    // Code for editing user
                    // Open a dialog or a new scene for editing user details
                    // You can create a method to handle this or use a different class for editing
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
            setGraphic(button);
        }
    }
}

