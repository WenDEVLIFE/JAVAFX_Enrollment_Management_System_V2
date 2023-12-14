/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Addgrades {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public void AddGrades(String entersub, String enterstudent, String entersection, int grade1, int grade2, int grade3, int grade4) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            // Find subjectID based on entersub (subject name)
            int subjectID = findSubjectID(connection, entersub);

            if (subjectID != -1) {
                // Find or create studentID based on enterstudent (student name)
           Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(SubjectID) FROM gradingtable");

            int highestId = 0;
            if (resultSet.next()) {
                highestId = resultSet.getInt(1);
            }

            // Increment the highest ID value by 1 to get the new ID value.
      
            int newId = highestId + 1;

                // Insert grades into the grades table
                insertGrades(connection,entersection, enterstudent, subjectID, newId , grade1, grade2, grade3, grade4);
            } else {
                System.out.println("Subject not found: " + entersub);
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


    private void insertGrades(Connection connection, String entersection, String enterstudent, int subjectID, int newId, int grade1, int grade2, int grade3, int grade4) throws SQLException {
        String insertGrades = "INSERT INTO gradingtable (SubjectID, StudentName, FirstG, SecondG, ThirdG, FourthG, Total,StudentID) VALUES (?, ?, ?, ?, ?, ?,? ,? ,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertGrades)) {
            preparedStatement.setInt(1, subjectID);
            preparedStatement.setString(2,  enterstudent);
            preparedStatement.setString(3,  entersection);
            preparedStatement.setInt(4, grade1);
            preparedStatement.setInt(5, grade2);
            preparedStatement.setInt(6, grade3);
            preparedStatement.setInt(7, grade4);

            // Calculate and set the average
            int average = (grade1 + grade2 + grade3 + grade4) / 4;
            preparedStatement.setInt(8, average);
               preparedStatement.setInt(9, newId);

            preparedStatement.executeUpdate();
            
            System.out.println("Done");
        }
    }
}
