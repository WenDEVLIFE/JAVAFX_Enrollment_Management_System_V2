/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */

public class Main extends Application {


      @Override

 public void start(Stage stage) {
  try {
   
   Parent root = FXMLLoader.load(getClass().getResource("mainfxml.fxml"));
   Scene scene = new Scene(root);
 Image icon = new Image(getClass().getResourceAsStream("/pictures/mabini.png"));
   stage.setScene(scene);
   stage.getIcons().add(icon);
   stage.setTitle("Mabini National HighSchool Management System Login");
   stage.show();
    stage.setResizable(false);
    
  } catch(Exception e) {
   e.printStackTrace();
  }
 } 

 public static void main(String[] args) {
  launch(args);
 }

}