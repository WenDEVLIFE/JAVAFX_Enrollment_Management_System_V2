/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author Administrator
 */
public class Addgrades {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

      public void addGrades(String enterSub, String enterStudent, String enterSection, int grade1, int grade2, int grade3, int grade4, String user_receiver) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            // Find subjectID based on enterSub (subject name)
            int subjectID = findSubjectID(connection, enterSub);

            if (subjectID != -1) {
                // Find or create newId based on the highest SubjectID in the gradingtable
                int newId = findHighestId(connection);

                // Increment the highest ID value by 1 to get the new ID value.

                // Insert grades into the grades table
                insertGrades(connection, enterSection, enterStudent, subjectID, newId, grade1, grade2, grade3, grade4);
            } else {
                System.out.println("Subject not found: " + enterSub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int findSubjectID(Connection connection, String subjectName) throws SQLException {
        // Use a parameterized query to prevent SQL injection and perform case-insensitive comparison
        String selectSubjectIDStatement = "SELECT SubjectID FROM subjecttable WHERE LOWER(SubjectName) = LOWER(?)";

        try (PreparedStatement selectSubjectIDPreparedStatement = connection.prepareStatement(selectSubjectIDStatement)) {
            selectSubjectIDPreparedStatement.setString(1, subjectName); // Set the parameter without changing case

            try (ResultSet resultSet = selectSubjectIDPreparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("SubjectID");
                } else {
                    return -1; // Indicates that the subject was not found
                }
            }
        }
    }

    private int findHighestId(Connection connection) throws SQLException {
        // Find the highest SubjectID in the gradingtable
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT MAX(SubjectID) FROM gradingtable");

            int highestId = 0;
            if (resultSet.next()) {
                highestId = resultSet.getInt(1);
            }

            return highestId + 1; // Increment the highest ID value by 1 to get the new ID value
        }
    }

    private void insertGrades(Connection connection, String enterSection, String enterStudent, int subjectID, int newId, int grade1, int grade2, int grade3, int grade4) throws SQLException {
        String insertGrades = "INSERT INTO gradingtable (SubjectID, StudentName, Section, FirstG, SecondG, ThirdG, FourthG, Total, StudentID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertGrades)) {
            preparedStatement.setInt(1, subjectID);
            preparedStatement.setString(2, enterStudent);
            preparedStatement.setString(3, enterSection);
            preparedStatement.setInt(4, grade1);
            preparedStatement.setInt(5, grade2);
            preparedStatement.setInt(6, grade3);
            preparedStatement.setInt(7, grade4);

            // Calculate and set the average
                int totalgrade = grade1 + grade2 + grade3 + grade4;
             double average = (double) totalgrade / 4;
            preparedStatement.setDouble(8, average);
            preparedStatement.setInt(9, newId);

            preparedStatement.executeUpdate();
 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Grades added successfully");
                alert.showAndWait();
                      System.gc();
   System.runFinalization();
            System.out.println("Done");
        }
    }
}