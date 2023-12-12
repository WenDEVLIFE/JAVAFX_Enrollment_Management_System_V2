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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

public class CreateStudent{
    private static TableView<Student> EnrollTable;
       private static ObservableList<Student> studentList = FXCollections.observableArrayList();
    public static String studentname, address, Phone, selected_Age, selected_gender ,birthmonth, birthdate, birthyear;
    String url = "jdbc:mysql://localhost:3306/mhns_enrollment_db"; // Change to your database URL
    String username = "root";
    String password = "";

     public CreateStudent(String studentname, String address, String Phone, String selected_Age, String selected_gender, String birthmonth, String birthdate, String birthyear, TableView<Student> EnrollTable, ObservableList<Student> studentList) {
       this.studentname = studentname;
        this.address = address;
        this.Phone = Phone;
        this.selected_Age= selected_Age;
        this.selected_gender= selected_gender;
        this.birthmonth = birthmonth;
        this.birthdate = birthdate;
        this.birthyear = birthyear;
        this.EnrollTable = EnrollTable;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       CreateStudent c = new CreateStudent(studentname, address, Phone, selected_Age, selected_gender ,birthmonth, birthdate, birthyear, EnrollTable,studentList);
        c.createstudent();
    }

   
    
     public void createstudent() throws SQLException, ClassNotFoundException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String alldate = birthmonth + "/" + birthdate + "/" + birthyear;

            // Check if the event name already exists in the database.
            if (isStudentExists(connection, studentname)) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Student already exists");
                alert.showAndWait();
                return; // Exit the method if the event name exists.
            }

            // Get the maximum ID value from the event table.
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(StudentID) FROM studentinformation");

            int highestId = 0;
            if (resultSet.next()) {
                highestId = resultSet.getInt(1);
            }

            // Increment the highest ID value by 1 to get the new ID value.
      
            int newId = generateRandomStudentID();
      int newId1 = highestId + newId + 1;
            // Create a prepared statement to insert a new event into the database.
            String insertSQL = "INSERT INTO studentinformation (StudentID, StudentName, Age, StudentAddress, Gender, BirthYear, PhoneNum) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Set the values for the prepared statement.
            insertStatement.setInt(1, newId1);
            insertStatement.setString(2, studentname);
            insertStatement.setString(3, selected_Age);
            insertStatement.setString(4, address);
            insertStatement.setString(5, selected_gender);
            insertStatement.setString(6, alldate);
            insertStatement.setString(7, Phone);

            // Execute the prepared statement.
            int rowsAffected = insertStatement.executeUpdate();

            // If the event was successfully added to the database, display a success message.
            if (rowsAffected == 1) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("System Message");
        alert.setHeaderText(null);
        alert.setContentText("Student Added Successfully");
        alert.showAndWait();
           Student newstudent = new Student(newId1, studentname, selected_Age, address, selected_gender,alldate,Phone);
EnrollTable.getItems().add(newstudent);
            } else {
 
            }
        }
    
}
 private boolean isStudentExists(Connection connection, String eventName) throws SQLException {
        String query = "SELECT COUNT(*) FROM studentinformation WHERE StudentName = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, eventName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Return true if the count is greater than 0 (event name exists)
            }
        }
        return false;
    }
 private int generateRandomStudentID() {
    // Replace this with your logic for generating a random StudentID
    return 100000 + (int) (Math.random() * 900000); // Generates a random 6-digit number
}
}

  