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
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.collections.ObservableList;

public class ButtonCell3 extends TableCell<Grading, Void> {
    private final Button button;
    private final ObservableList<Grading> gradingList;
    
    public ButtonCell3(String buttonText, ObservableList<Grading> gradingList) {
        this.button = new Button(buttonText);
        this.gradingList = gradingList;

        this.button.setOnAction(event -> {
            Grading selectedGrading = getTableRow().getItem();
            if (selectedGrading != null) {
                if (buttonText.equals("Delete")) {
                    // Code for deleting grading
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to delete this grading?");

                    ButtonType buttonTypeYes = new ButtonType("Yes");
                    ButtonType buttonTypeNo = new ButtonType("No");

                    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                    alert.showAndWait().ifPresent(response -> {
                        if (response == buttonTypeYes) {
                            System.out.println(selectedGrading);
                            // Code to delete grading from the database and update the list
                            DeleteInformationDB db = new DeleteInformationDB();
                       
                            gradingList.remove(selectedGrading);
                            System.gc();
                        }
                    });
                } else if (buttonText.equals("Edit")) {
                    System.out.println("Edit Grades");
                    // Code for editing grading
                    // Open a dialog or a new scene for editing grading details
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