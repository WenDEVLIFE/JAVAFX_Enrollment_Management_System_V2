/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinteraction;

/**
 *
 * @author Administrator
 */
import functions.User;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<User, Void> {
    private final Button button;

    public ButtonCell(String buttonText) {
        this.button = new Button(buttonText);
        this.button.setOnAction(event -> {
            // Handle button click event
            // For example, you can access the current row's data using getItem()
            User user = getTableRow().getItem();
            if (user != null) {
                System.out.println("Button clicked for user: " + user.getUsername());
                // Perform delete or edit action as needed
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
