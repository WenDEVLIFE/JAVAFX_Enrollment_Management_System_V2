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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CreateStudent {
    private static TableView<Student> EnrollTable;
    private static TableView<Reports> ReportTable;
    private static String     user1 ;
    private static final ObservableList<Student> studentList = FXCollections.observableArrayList();
    public static String studentname, address, Phone, selected_Age, selected_gender, birthmonth, birthdate, birthyear;
    String url = "jdbc:mysql://localhost:3306/mhns_enrollment_db"; // Change to your database URL
    String username = "root";
    String password = "";
   private static TextField Studentname;
   private static TextField Address;
   private static TextField phonenumber;
   private static ComboBox<String> Age;
   private static ComboBox<String> gender;
   private static ComboBox<String> month;
   private static ComboBox<String> year;
   private static ComboBox<String> day;
    public CreateStudent(String studentname, String address, String Phone, String selected_Age, String selected_gender, String birthmonth, String birthdate, String birthyear, TableView<Student> EnrollTable, ObservableList<Student> studentList, String     user1 , TableView<Reports> ReportTable) {
        CreateStudent.studentname = studentname;
        CreateStudent.address = address;
        CreateStudent.Phone = Phone;
        CreateStudent.selected_Age = selected_Age;
        CreateStudent.selected_gender = selected_gender;
        CreateStudent.birthmonth = birthmonth;
        CreateStudent.birthdate = birthdate;
        CreateStudent.birthyear = birthyear;
        CreateStudent.EnrollTable = EnrollTable;
        CreateStudent.ReportTable = ReportTable;
   CreateStudent.    user1 =  user1 ;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CreateStudent c = new CreateStudent(studentname, address, Phone, selected_Age, selected_gender, birthmonth, birthdate, birthyear, EnrollTable, studentList,     user1 , ReportTable);
        c.createstudent(Studentname, Address, phonenumber, Age, gender, month, year, day);
    }

    public void createstudent(TextField Studentname, TextField Address, TextField phonenumber, ComboBox<String> Age, ComboBox<String> gender, ComboBox<String> month, ComboBox<String> year, ComboBox<String> day) throws SQLException, ClassNotFoundException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String alldate = birthmonth + "/" + birthdate + "/" + birthyear;

            // Check if the student name already exists in the database.
            if (isStudentExists(connection, studentname)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Student already exists");
                alert.showAndWait();
                return; // Exit the method if the student name exists.
            }

    
            // Increment the highest ID value by 1 to get the new ID value.
            int newId = generateRandomStudentID();

            // Create a prepared statement to insert a new student into the database.
            String insertSQL = "INSERT INTO studentinformation (StudentID, StudentName, Age, StudentAddress, Gender, BirthYear, PhoneNum) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            // Set the values for the prepared statement.
            insertStatement.setInt(1, newId);
            insertStatement.setString(2, studentname);
            insertStatement.setString(3, selected_Age);
            insertStatement.setString(4, address);
            insertStatement.setString(5, selected_gender);
            insertStatement.setString(6, alldate);
            insertStatement.setString(7, Phone);

            // Execute the prepared statement.
            int rowsAffected = insertStatement.executeUpdate();

            // Get the maximum ReportID value from the reports table.
            Statement statement1 = connection.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("SELECT MAX(ReportID) FROM reports");

            int highestId1 = 0;
            if (resultSet1.next()) {
                highestId1 = resultSet1.getInt(1);
            }

            // Increment the highest ID value by 1 to get the new ID value.
            int newId2 = highestId1 + 1;

            // Create a prepared statement to insert a new report into the database.
            String insertSQL1 = "INSERT INTO reports (ReportID, username, date, activity) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement1 = connection.prepareStatement(insertSQL1, Statement.RETURN_GENERATED_KEYS);

            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            insertStatement1.setInt(1, newId2);
            insertStatement1.setString(2,     user1 );
            insertStatement1.setString(3, formattedDate);
            insertStatement1.setString(4, "Create Student");

            // Execute the prepared statement for report insertion.
            int reportRowsAffected = insertStatement1.executeUpdate();

            // If the student was successfully added to the database, display a success message.
            if (rowsAffected == 1 && reportRowsAffected == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Student Added Successfully");
                alert.showAndWait();

                Student newstudent = new Student(newId, studentname, address, selected_gender, selected_Age, Phone, alldate);
                EnrollTable.getItems().add(newstudent);

                Reports newreport = new Reports(newId2,     user1 , formattedDate, "Create Student");
                ReportTable.getItems().add(newreport);
            }
        }
    }

    private boolean isStudentExists(Connection connection, String studentname) throws SQLException {
        String query = "SELECT COUNT(*) FROM studentinformation WHERE StudentName = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, studentname);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Return true if the count is greater than 0 (student name exists)
            }
        }
        return false;
    }

    private int generateRandomStudentID() {
        // Replace this with your logic for generating a random StudentID
        return 100000 + (int) (Math.random() * 900000); // Generates a random 6-digit number
    }
}
  