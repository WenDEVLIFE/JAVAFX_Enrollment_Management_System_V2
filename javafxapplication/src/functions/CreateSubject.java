/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import static functions.CreateStudent.studentname;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 *
 * @author Administrator
 */
public class CreateSubject {
     private static TableView<Subject> SubjectTable;
       private static final ObservableList<Subject> subjectList = FXCollections.observableArrayList();
      String url = "jdbc:mysql://localhost:3306/mhns_enrollment_db"; // Change to your database URL
    String username = "root";
    String password = "";
    private static String sub, sec, time_start, time_end;
    
      public static void main(String[] args) throws SQLException, ClassNotFoundException {
       CreateSubject cs = new CreateSubject(sub, sec, time_start, time_end,SubjectTable, subjectList);
        cs.create_subjects();
    }
      public CreateSubject (String sub, String sec, String time_start, String time_end, TableView<Subject> SubjectTable, ObservableList<Subject> subjectList){
          CreateSubject.sub=sub;
          CreateSubject.sec=sec;
          CreateSubject.time_start = time_start;
          CreateSubject.time_end = time_end;
          CreateSubject.SubjectTable = SubjectTable;

      }

    public void create_subjects() throws SQLException{
   try (Connection connection = DriverManager.getConnection(url, username, password)) {
      
           
            // Get the maximum ID value from the event table.
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(SubjectID) FROM subjecttable");

            int highestId = 0;
            if (resultSet.next()) {
                highestId = resultSet.getInt(1);
            }

            // Increment the highest ID value by 1 to get the new ID value.
      
            int newId = highestId + 1;

            // Create a prepared statement to insert a new event into the database.
            String insertSQL = "INSERT INTO subjecttable (SubjectID, SubjectName, Section, TimeStart, TimeEnded) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Set the values for the prepared statement.
            insertStatement.setInt(1, newId);
            insertStatement.setString(2, sub);
            insertStatement.setString(3, sec);
            insertStatement.setString(4, time_start);
            insertStatement.setString(5, time_end);
          

            // Execute the prepared statement.
            int rowsAffected = insertStatement.executeUpdate();

            // If the event was successfully added to the database, display a success message.
            if (rowsAffected == 1) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("System Message");
        alert.setHeaderText(null);
        alert.setContentText("Subject added successfully");
        alert.showAndWait();
Subject newSubject = new Subject(newId, sub, sec, time_start, time_end);
SubjectTable.getItems().add(newSubject);
             System.gc();
   System.runFinalization();
            
            } else {
 
            }
        }
    
}

    
}
