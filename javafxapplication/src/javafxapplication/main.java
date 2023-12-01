/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication;

import javafx.scene.image.Image;
import java.io.IOException;
import java.io.InputStream;
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
    public void start(Stage primaryStage) throws IOException {
        // Load the FXML file using FXMLLoader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainfxml.fxml"));
        Parent root = loader.load();

        // Set up the scene
        Scene scene = new Scene(root, 618, 631);
        scene.getStylesheets().add(getClass().getResource("mainfxml.css").toExternalForm());

        // Make sure the path to the image is correct
        InputStream iconStream = getClass().getResourceAsStream("/icons8-user-60.png");
        if (iconStream != null) {
            primaryStage.getIcons().add(new Image(iconStream));
        } else {
            System.out.println("Error loading icon.");
        }

        // Set the scene to the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.setResizable(false);

        // Set the scene to the primary stage
        primaryStage.show();
    }

    // this is for sign up
   public static void showSignup(Stage primaryStage) throws IOException {
    // Load the FXML file using FXMLLoader with an absolute path
    FXMLLoader loader = new FXMLLoader(Main.class.getResource("/signup/sign_up_xml.fxml"));
    Parent root = loader.load();

    // Set up the scene
    Scene scene = new Scene(root, 618, 631);

    // Make sure the path to the image is correct
    InputStream iconStream = Main.class.getResourceAsStream("/icons8-user-60.png");
    if (iconStream != null) {
        primaryStage.getIcons().add(new Image(iconStream));
    } else {
        System.out.println("Error loading icon.");
    }

    // Set the scene to the primary stage
    primaryStage.setScene(scene);
    primaryStage.setTitle("Signup"); // Change the title accordingly
    primaryStage.setResizable(false);

    // Show the primary stage
    primaryStage.show();
}

    public static void main(String[] args) {
        launch(args);
    }
}