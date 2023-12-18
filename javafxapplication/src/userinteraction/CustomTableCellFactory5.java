/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinteraction;

import com.javafx.functions.Grading;
import com.javafx.functions.Reports;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Administrator
 */
public class CustomTableCellFactory5 {

    public static TableCell<Reports, String> cellFactoryForString(TableColumn<Reports, String> column) {
        return new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item);
                setAlignment(Pos.CENTER);
            }
        };
    }

    public static TableCell<Reports, Integer> cellFactoryForInteger(TableColumn<Reports, Integer> column) {
        return new TableCell<>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.toString());
                setAlignment(Pos.CENTER);
            }
        };
    }

    public static TableCell<Reports, String> createCenteredStringCell(TableColumn<Reports, String> column) {
        return new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item);
                setAlignment(Pos.CENTER);
            }
        };
    }
}