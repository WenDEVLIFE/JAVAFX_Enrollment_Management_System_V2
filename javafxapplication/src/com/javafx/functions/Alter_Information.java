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
import javafx.scene.control.Alert;
/**
 *
 * @author Administrator
 */
public class Alter_Information {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    public void altergrades(String find_entersub, String find_enterstudent, int update_grade1, int update_grade2, int update_grade3, int update_grade4){
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Assuming you have a table named 'grades' with columns: subjectID, studentName, grade1, grade2, grade3, grade4, average
            String updateQuery = "UPDATE gradingtable SET FirstG =?, SecondG=?, ThirdG=?, FourthG=?, Total=? " +
                                 "WHERE SubjectID=(SELECT SubjectID FROM subjecttable WHERE SubjectName=?) " +
                                 "AND StudentName=?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, update_grade1);
                preparedStatement.setInt(2, update_grade2);
                preparedStatement.setInt(3, update_grade3);
                preparedStatement.setInt(4, update_grade4);
                double average = (update_grade1 + update_grade2 + update_grade3 + update_grade4) / 4.0;
                preparedStatement.setDouble(5, average);
                preparedStatement.setString(6, find_entersub);
                preparedStatement.setString(7, find_enterstudent);

                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Grades updated successfully!");
                           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("System Message");
                                alert.setHeaderText(null);
                                alert.setContentText("Grades has been updated");
                                alert.showAndWait();
                } else {
                    System.out.println("No records found for the given subject and student.");
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("System Message");
                                alert.setHeaderText(null);
                                alert.setContentText("No records found for the given subject and student.");
                                alert.showAndWait();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
public void changeinformation(String update_studentname, String new_name, String new_address, String new_phone_number, String new_gender, String update_age, String update_month, String update_day, String update_year) throws SQLException {
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM studentinformation WHERE StudentName = ?")) {

            statement.setString(1, update_studentname);
            try (ResultSet resultSet = statement.executeQuery()) {
                boolean studentExists = resultSet.next(); // true if student found, false otherwise

                        String alldate = update_month + "/" + update_day + "/" + update_year;
                if (studentExists) {
                    try (PreparedStatement updateStatement = connection.prepareStatement("UPDATE studentinformation SET StudentName = ?, Age = ?, StudentAddress = ?, Gender = ?,  Birthyear= ?, PhoneNum = ? WHERE StudentName = ?")) {
                            updateStatement.setString(1, new_name);
                            updateStatement.setString(2, update_age);
                            updateStatement.setString(3, new_address);
                            updateStatement.setString(4, new_gender);
                            updateStatement.setString(5, alldate );
                            updateStatement.setString(6, new_phone_number);
                             updateStatement.setString(7, update_studentname); // Corrected index
                   
                
                        

                        updateStatement.executeUpdate();
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("System Message");
                                alert.setHeaderText(null);
                                alert.setContentText("Student has been updated");
                                alert.showAndWait();
                    }
                    
                } else{
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("System Message");
                                alert.setHeaderText(null);
                                alert.setContentText("Student not found");
                                alert.showAndWait();
                }
            }
        }
    } catch (SQLException e) {
        // Handle any SQL exceptions
        e.printStackTrace(); // Or log the exception
    }
}
}
