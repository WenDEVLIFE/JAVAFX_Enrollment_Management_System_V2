/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinteraction;

/**
 *
 * @author Administrator
 */
import functions.Grading;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SubjectDatabase {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

  public List<Grading> getGradingBySubjectName(String subjectName) {
    List<Grading> gradingList = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        // Select SubjectID and other fields based on SubjectName
        String sql = "SELECT SubjectID, StudentName, Section, FirstG, SecondG, ThirdG, FourthG, Total FROM gradingtable WHERE SubjectID IN (SELECT SubjectID FROM subjecttable WHERE SubjectName = ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, subjectName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Record found, extract details
                    int subjectID = resultSet.getInt("SubjectID");
                    String studentName = resultSet.getString("StudentName");
                    String section = resultSet.getString("Section");
                    int firstGrading = resultSet.getInt("FirstGrading");
                    int secondGrading = resultSet.getInt("SecondGrading");
                    int thirdGrading = resultSet.getInt("ThirdGrading");
                    int forthGrading = resultSet.getInt("ForthGrading");
                    int total = resultSet.getInt("Total");

                    // Create Grading instance
                    Grading grading = new Grading(subjectID, studentName, section, firstGrading, secondGrading, thirdGrading, forthGrading, total);
                    gradingList.add(grading);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle any database-related exceptions here
    }

    return gradingList;
}
}