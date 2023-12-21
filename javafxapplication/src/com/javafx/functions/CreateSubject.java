/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

import static com.javafx.functions.CreateStudent.Phone;
import static com.javafx.functions.CreateStudent.address;
import static com.javafx.functions.CreateStudent.selected_Age;
import static com.javafx.functions.CreateStudent.selected_gender;
import static com.javafx.functions.CreateStudent.studentname;
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

/**
 *
 * @author Administrator
 */
public class CreateSubject {
    private static TableView<Subject> SubjectTable;
    private static TableView<Reports> ReportTable;
    private static String     user1 ;
    private static final ObservableList<Subject> subjectList = FXCollections.observableArrayList();
    String url = "jdbc:mysql://localhost:3306/mhns_enrollment_db"; // Change to your database URL
    String username = "root";
    String password = "";
    private static String sub, sec, time_start, time_end;
    
    private static TextField subjectfield;
    private static ComboBox <String> Selectedsection;
    
    private static ComboBox <String> Selectedstarttime;
    
        private static ComboBox <String> Selectedendtime;

    /**
     *
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CreateSubject cs = new CreateSubject(sub, sec, time_start, time_end, SubjectTable, subjectList,     user1);
        cs.create_subjects(subjectfield, Selectedsection, Selectedstarttime, Selectedendtime);
    }

    public CreateSubject(String sub, String sec, String time_start, String time_end, TableView<Subject> SubjectTable, ObservableList<Subject> subjectList, String user_receiver) {
        CreateSubject.sub = sub;
        CreateSubject.sec = sec;
        CreateSubject.time_start = time_start;
        CreateSubject.time_end = time_end;
        CreateSubject.SubjectTable = SubjectTable;
        CreateSubject.ReportTable = ReportTable;
        CreateSubject.    user1  =     user1 ;
    }

    public void create_subjects(TextField subjectfield, ComboBox<String> Selectedsection, ComboBox<String> Selectedstarttime, ComboBox<String> Selectedendtime) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(SubjectID) FROM subjecttable");

            int highestId = 0;
            if (resultSet.next()) {
                highestId = resultSet.getInt(1);
            }

            int newId = highestId + 1;

            String insertSQL = "INSERT INTO subjecttable (SubjectID, SubjectName, Section, TimeStart, TimeEnded) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            insertStatement.setInt(1, newId);
            insertStatement.setString(2, sub);
            insertStatement.setString(3, sec);
            insertStatement.setString(4, time_start);
            insertStatement.setString(5, time_end);

            int rowsAffected = insertStatement.executeUpdate();

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
            insertStatement1.setString(4, "Create Subject");

            int reportRowsAffected = insertStatement1.executeUpdate();

            if (rowsAffected == 1 && reportRowsAffected == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System Message");
                alert.setHeaderText(null);
                alert.setContentText("Subject added successfully");
                alert.showAndWait();

                Subject newSubject = new Subject(newId, sub, sec, time_start, time_end);
                SubjectTable.getItems().add(newSubject);

                Reports newreport = new Reports(newId1,     user1 , formattedDate, "Create Subject");
                ReportTable.getItems().add(newreport);

                Selectedstarttime.setValue("Select a time");
                Selectedendtime.setValue("Select a time");
                Selectedsection.setValue("Select a section");
                subjectfield.setText("");
                
                System.gc();
                System.runFinalization();
            }
        }
    }
}