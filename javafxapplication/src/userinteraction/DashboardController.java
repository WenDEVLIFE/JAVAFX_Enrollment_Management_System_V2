/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userinteraction;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class DashboardController {

    @FXML
    private Tab DASHB;

    @FXML
    private Tab Enroll;

    @FXML
    private Button Enrollaction;

    @FXML
    private TabPane TabPanesel;

    @FXML
    private Button dashboards;

    @FXML
    private Pane tabbedpanemenu;



  

    @FXML
    void Enroll_Action(ActionEvent event) {
TabPanesel.getSelectionModel().select(DASHB);

    }  
    @FXML
    void dashboard_Action(ActionEvent event) {
TabPanesel.getSelectionModel().select(Enroll);
    }

}