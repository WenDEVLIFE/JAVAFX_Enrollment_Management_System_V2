/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javafx.scene.control.Alert;
public class DeleteInformationDB {
    String jdbcUrl = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    String username1 = "root";
    String password = "";

    public void deleteuser(User user) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username1, password)) {
            String deleteQuery = "DELETE FROM usertable WHERE UserID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, user.getId()); // Assuming there's a method named getId() in your User class
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("User deleted successfully");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("User deletion successfully");
                alert.showAndWait();

                } else {
                    System.out.println("User deletion failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void deleteStudent(Student selectedStudent) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username1, password)) {
            String deleteQuery = "DELETE FROM studentinformation WHERE StudentID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, selectedStudent.getId()); // Assuming there's a method named getId() in your User class
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Student deleted successfully");
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Student deletion successfully");
                alert.showAndWait();
                      System.gc();
   System.runFinalization();

                } else {
                    System.out.println("Student deletion failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void deletesubject(Subject selectedSubject){
           try (Connection connection = DriverManager.getConnection(jdbcUrl, username1, password)) {
            String deleteQuery = "DELETE FROM subjecttable WHERE SubjectID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, selectedSubject.getSubjectId()); // Assuming there's a method named getId() in your User class
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Student deleted successfully");
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Subject deletion successfully");
                alert.showAndWait();
                      System.gc();
   System.runFinalization();

                } else {
                    System.out.println("Subject deletion failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
     public void deletegrades(){
         
     }
}
