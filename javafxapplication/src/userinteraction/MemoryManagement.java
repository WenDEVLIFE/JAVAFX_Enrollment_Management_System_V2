/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinteraction;

import functions.User;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class MemoryManagement {
    // Buttons
    private Button Enrollaction;
    private Button dashboards;
    private Button gradesbuttonaction;
    private Button   reportbutton;

    // Panes
    private Pane  tabbedpanemenu;

    // TableViews
    private TableView<?> EnrollTable;
    private TableView<User> adminTable;

    // ComboBoxes
    private ComboBox<String> selecttable;
    private ComboBox<String> selecttable1;
    private ComboBox<String> selecttable2;
    private ComboBox<String> selecttable3;
    private ComboBox<String> selecttable4;
    private ComboBox<String> selecttable5;
    private ComboBox<String> selecttable6;
    private ComboBox<String> Role;

    // MenuButtons
    private MenuButton menuactions;
    private MenuButton menuactions1;
    private MenuButton menuactions2;
    private MenuButton menuactions3;
    private MenuButton menuactions4;
    private MenuButton menuactions5;
    private MenuButton menuactions6;
    private MenuButton menuactions7;
    private MenuButton menuactions8;
        private MenuButton menuactions9;

    public MemoryManagement(
            Button Enrollaction, Button dashboards, Button gradesbuttonaction, Button   reportbutton, Pane tabbedpanemenu, TableView<?> enrollTable, TableView<User> adminTable, ComboBox<String> selecttable, ComboBox<String> selecttable1, ComboBox<String> selecttable2, ComboBox<String> selecttable3, ComboBox<String> selecttable4, ComboBox<String> selecttable5, ComboBox<String> selecttable6, ComboBox<String> Role, MenuButton menuactions, MenuButton menuactions1, MenuButton menuactions2, MenuButton menuactions3, MenuButton menuactions4, MenuButton menuactions5, MenuButton menuactions6, MenuButton menuactions7, MenuButton menuactions8, MenuButton menuactions9) {

        this.Enrollaction = Enrollaction;
        this.dashboards = dashboards;
        this.gradesbuttonaction = gradesbuttonaction;
        this.  reportbutton =   reportbutton;

        this. tabbedpanemenu =  tabbedpanemenu;

        this.EnrollTable = enrollTable;
        this.adminTable = adminTable;

        this.selecttable = selecttable;
        this.selecttable1 = selecttable1;
        this.selecttable2 = selecttable2;
        this.selecttable3 = selecttable3;
        this.selecttable4 = selecttable4;
        this.selecttable5 = selecttable5;
        this.selecttable6 = selecttable6;
        this.Role = Role;

        this.menuactions = menuactions;
        this.menuactions1 = menuactions1;
        this.menuactions2 = menuactions2;
        this.menuactions3 = menuactions3;
        this.menuactions4 = menuactions4;
        this.menuactions5 = menuactions5;
        this.menuactions6 = menuactions6;
        this.menuactions7 = menuactions7;
        this.menuactions8 = menuactions8;
        this.menuactions9 = menuactions9;
    }

    public void disableLeaks() {
        Enrollaction.setOnAction(null);
        dashboards.setOnAction(null);
        gradesbuttonaction.setOnAction(null);
         reportbutton.setOnAction(null);

        menuactions.setOnAction(null);
        menuactions1.setOnAction(null);
        menuactions2.setOnAction(null);
        menuactions3.setOnAction(null);
        menuactions4.setOnAction(null);
        menuactions5.setOnAction(null);
        menuactions6.setOnAction(null);
        menuactions7.setOnAction(null);
        menuactions8.setOnAction(null);
        menuactions9.setOnAction(null);

        selecttable.setDisable(true);
        selecttable1.setDisable(true);
        selecttable2.setDisable(true);
        selecttable3.setDisable(true);
        selecttable4.setDisable(true);
        selecttable5.setDisable(true);
        selecttable6.setDisable(true);

        Role.setDisable(true);
    }
}
