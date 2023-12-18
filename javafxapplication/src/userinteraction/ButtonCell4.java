/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinteraction;

import com.javafx.functions.DeleteInformationDB;
import com.javafx.functions.Reports;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;

/**
 *
 * @author Administrator
 */
public class ButtonCell4 extends TableCell<Reports, Void> {
    private final Button button;
ObservableList<Reports>  reportList;
private String user1;
    
    public ButtonCell4(String buttonText, ObservableList<Reports> reportList, TableView<Reports> ReportTable, String user1) {
        this.button = new Button(buttonText);
        this. reportList= reportList;
        this.user1 = user1;

        this.button.setOnAction(event -> {
           Reports selectedreports = getTableRow().getItem();
            if (selectedreports != null) {
                if (buttonText.equals("Delete")) {
                    // Code for deleting grading
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to delete this grading?");

                    ButtonType buttonTypeYes = new ButtonType("Yes");
                    ButtonType buttonTypeNo = new ButtonType("No");

                    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                    alert.showAndWait().ifPresent(new Consumer<ButtonType>() {
                        @Override
                        public void accept(ButtonType response) {
                            if (response == buttonTypeYes) {
                                try {
                                    System.out.println(selectedreports);
                                    // Code to delete grading from the database and update the list
                                    DeleteInformationDB db = new DeleteInformationDB();
                                    db.Delete_report(selectedreports,user1);
                                   reportList.remove(selectedreports);
                                    
                                    System.gc();
                                } catch (SQLException ex) {
                                    Logger.getLogger(ButtonCell4.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    });
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
            }

            setGraphic(button);
        }
    }
public Button getButton() {
        return button;
    }
}