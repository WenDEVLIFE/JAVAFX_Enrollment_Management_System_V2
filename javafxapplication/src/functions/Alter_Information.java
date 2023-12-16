/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    public void changeinformation(){
           
       }
}
