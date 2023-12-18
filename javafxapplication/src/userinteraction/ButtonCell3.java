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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class ButtonCell3 extends TableCell<Grading, Void> {
    private final Button button;
    private final ObservableList<Grading> gradingList;
    private static String user1;
    public ButtonCell3(String buttonText, ObservableList<Grading> gradingList, TabPane TabPanesel, Tab Changestudentinfo,String user1) {
        this.button = new Button(buttonText);
        this.gradingList = gradingList;
        this.user1 = user1;

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
                            try {
                                System.out.println(selectedGrading);
                                // Code to delete grading from the database and update the list
                                DeleteInformationDB db = new DeleteInformationDB();
                                db.deletegrades( selectedGrading, user1);
                                System.gc();
                            } catch (SQLException ex) {
                                Logger.getLogger(ButtonCell3.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                } else if (buttonText.equals("Edit")) {
                    System.out.println("Edit Grades");
                    
                            TabPanesel.getSelectionModel().select(Changestudentinfo);
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