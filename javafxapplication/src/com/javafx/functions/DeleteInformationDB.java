/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class DeleteInformationDB {
    String jdbcUrl = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    String username1 = "root";
    String password = "";

    // To delete user
    public void deleteuser(User user,String user1) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username1, password)) {
            String deleteQuery = "DELETE FROM usertable WHERE UserID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, user.getId()); // Assuming there's a method named getId() in your User class
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("User deleted successfully");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        String iconPath = "pictures/enrollment_managemet_system.png";
                // Load the PNG image
                Image iconImage = new Image(iconPath);

                ImageView imageView = new ImageView(iconImage);
                imageView.setFitWidth(64);
                imageView.setFitHeight(64);
                alert.getDialogPane().setGraphic(imageView);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("User deletion successfully");
                alert.showAndWait();
                
                   Statement statement1 = connection.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("SELECT MAX(ReportID) FROM reports");

            int highestId1 = 0;
            if (resultSet1.next()) {
                highestId1 = resultSet1.getInt(1);
            }

            int newId1 = highestId1 + 1;

            String insertSQL1 = "INSERT INTO reports (ReportID, username, date, activity) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement1 = connection.prepareStatement(insertSQL1, Statement.RETURN_GENERATED_KEYS);

            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            insertStatement1.setInt(1, newId1);
            insertStatement1.setString(2,     user1 );
            insertStatement1.setString(3, formattedDate);
            insertStatement1.setString(4, "Delete Student");

            int reportRowsAffected = insertStatement1.executeUpdate();
            
             if( reportRowsAffected ==1){
                System.out.println("Done recording reports");
            }

                } else {
                    System.out.println("User deletion failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // To delete student
     public void deleteStudent(Student selectedStudent, String user1) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username1, password)) {
            String deleteQuery = "DELETE FROM studentinformation WHERE StudentID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, selectedStudent.getId()); // Assuming there's a method named getId() in your User class
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Student deleted successfully");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                           String iconPath = "pictures/enrollment_managemet_system.png";
                  // Load the PNG image
                  Image iconImage = new Image(iconPath);

                  ImageView imageView = new ImageView(iconImage);
                  imageView.setFitWidth(64);
                  imageView.setFitHeight(64);
                  alert.getDialogPane().setGraphic(imageView);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Student deletion successfully");
                alert.showAndWait();
                      System.gc();
   System.runFinalization();
           Statement statement1 = connection.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("SELECT MAX(ReportID) FROM reports");

            int highestId1 = 0;
            if (resultSet1.next()) {
                highestId1 = resultSet1.getInt(1);
            }

            int newId1 = highestId1 + 1;

            String insertSQL1 = "INSERT INTO reports (ReportID, username, date, activity) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement1 = connection.prepareStatement(insertSQL1, Statement.RETURN_GENERATED_KEYS);

            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            insertStatement1.setInt(1, newId1);
            insertStatement1.setString(2,     user1 );
            insertStatement1.setString(3, formattedDate);
            insertStatement1.setString(4, "Delete Student");

            int reportRowsAffected = insertStatement1.executeUpdate();
            
             if( reportRowsAffected ==1){
                System.out.println("Done recording reports");
            }

                } else {
                    System.out.println("Student deletion failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     // To delete subject
    public void deletesubject(Subject selectedSubject, String user1) {
    try (Connection connection = DriverManager.getConnection(jdbcUrl, username1, password)) {
        // Assuming there's a method named getSubjectId() in your Subject class
        String deleteQuery = "DELETE FROM subjecttable WHERE SubjectID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, selectedSubject.getSubjectId());
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Subject deleted successfully");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   String iconPath = "pictures/enrollment_managemet_system.png";
                // Load the PNG image
                Image iconImage = new Image(iconPath);

                ImageView imageView = new ImageView(iconImage);
                imageView.setFitWidth(64);
                imageView.setFitHeight(64);
                alert.getDialogPane().setGraphic(imageView);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Subject deletion successfully");
                alert.showAndWait();

                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("SELECT MAX(ReportID) FROM reports");

                int highestId1 = 0;
                if (resultSet1.next()) {
                    highestId1 = resultSet1.getInt(1);
                }

                int newId1 = highestId1 + 1;

                String insertSQL1 = "INSERT INTO reports (ReportID, username, date, activity) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStatement1 = connection.prepareStatement(insertSQL1, Statement.RETURN_GENERATED_KEYS);

                LocalDate currentDate = LocalDate.now();
                String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                insertStatement1.setInt(1, newId1);
                insertStatement1.setString(2, user1);
                insertStatement1.setString(3, formattedDate);
                insertStatement1.setString(4, "Delete Subject");

                int reportRowsAffected = insertStatement1.executeUpdate();

                if (reportRowsAffected == 1) {
                    System.out.println("Done recording reports");
                }

            } else {
                System.out.println("Subject deletion failed");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    // To delete grades
    public void deletegrades(Grading selectedGrading, String user1) throws SQLException {
    try (Connection connection = DriverManager.getConnection(jdbcUrl, username1, password)) {
        String deleteQuery = "DELETE FROM gradingtable WHERE StudentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, selectedGrading.getStudentID()); // Assuming there's a method named getStudentID() in your Grading class
            int rowsDeleted = preparedStatement.executeUpdate();
            
                Statement statement1 = connection.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("SELECT MAX(ReportID) FROM reports");

            int highestId1 = 0;
            if (resultSet1.next()) {
                highestId1 = resultSet1.getInt(1);
            }

            int newId1 = highestId1 + 1;

            String insertSQL1 = "INSERT INTO reports (ReportID, username, date, activity) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement1 = connection.prepareStatement(insertSQL1, Statement.RETURN_GENERATED_KEYS);

            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            insertStatement1.setInt(1, newId1);
            insertStatement1.setString(2,     user1 );
            insertStatement1.setString(3, formattedDate);
            insertStatement1.setString(4, "Delete Student");

            int reportRowsAffected = insertStatement1.executeUpdate();
            
             if( reportRowsAffected ==1){
                System.out.println("Done recording reports");
            }
            if (rowsDeleted > 0) {
                System.out.println("Grading deleted successfully");
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                String iconPath = "pictures/enrollment_managemet_system.png";
                // Load the PNG image
                Image iconImage = new Image(iconPath);

                ImageView imageView = new ImageView(iconImage);
                imageView.setFitWidth(64);
                imageView.setFitHeight(64);
                alert.getDialogPane().setGraphic(imageView);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Grading deletion successfully");
                alert.showAndWait();
                System.gc();
                System.runFinalization();
            } else {
                System.out.println("Grading deletion failed");
            }
        }
    }
}
    
    // To delete the reports
    public void Delete_report(Reports selectedreports, String user1) throws SQLException{
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username1, password)) {
        String deleteQuery = "DELETE FROM reports WHERE ReportID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, selectedreports.getId()); // Assuming there's a method named getStudentID() in your Grading class
            int rowsDeleted = preparedStatement.executeUpdate();
            
                Statement statement1 = connection.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("SELECT MAX(ReportID) FROM reports");

            int highestId1 = 0;
            if (resultSet1.next()) {
                highestId1 = resultSet1.getInt(1);
            }

            int newId1 = highestId1 + 1;

            String insertSQL1 = "INSERT INTO reports (ReportID, username, date, activity) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement1 = connection.prepareStatement(insertSQL1, Statement.RETURN_GENERATED_KEYS);

            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            insertStatement1.setInt(1, newId1);
            insertStatement1.setString(2,     user1 );
            insertStatement1.setString(3, formattedDate);
            insertStatement1.setString(4, "Delete Student");

            int reportRowsAffected = insertStatement1.executeUpdate();
            
             if( reportRowsAffected ==1){
                System.out.println("Done recording reports");
            }
            if (rowsDeleted > 0) {
                System.out.println("Grading deleted successfully");
                
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  String iconPath = "pictures/enrollment_managemet_system.png";
                // Load the PNG image
                Image iconImage = new Image(iconPath);

                ImageView imageView = new ImageView(iconImage);
                imageView.setFitWidth(64);
                imageView.setFitHeight(64);
                alert.getDialogPane().setGraphic(imageView);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Report deletion successfully");
                alert.showAndWait();
                System.gc();
                System.runFinalization();
            } else {
                System.out.println("Report deletion failed");
            }
        }
    }
    }
}
