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
import com.javafx.functions.User;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ButtonCell extends TableCell<User, Void> {
    private final Button button;
    private final ObservableList<User> userList ;
    private String user1;
   public ButtonCell(String buttonText, ObservableList<User> userList, TabPane TabPanesel, Tab changeCredentials ,String user1 ) {
    this.button = new Button(buttonText);
       this.userList   = userList ;
       this.user1 = user1 ;
    this.button.setOnAction(event -> {
        User user = getTableRow().getItem();
        if (user != null) {
            if (buttonText.equals("Delete")) {
                // Code for deleting user
                System.out.println("Button clicked for user: " + user.getUsername());
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
                alert.setContentText("Are you sure you want to delete this user?");

                ButtonType buttonTypeYes = new ButtonType("Yes");
                ButtonType buttonTypeNo = new ButtonType("No");

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                alert.showAndWait().ifPresent(response -> {
                    if (response == buttonTypeYes) {
                        DeleteInformationDB db = new DeleteInformationDB();
                        db.deleteuser(user,user1 );
                          userList.remove(user);

                                 System.gc();
                        
                    }
                });
            } else if (buttonText.equals("Edit")) {
                // Code for editing user
                   TabPanesel.getSelectionModel().select(changeCredentials);
             

                // Open a dialog or a new scene for editing user details
                // You can create a method to handle this, or use a different class for editing
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
