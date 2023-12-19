/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Administrator
 */
public class verification_info {
    private String mydb_url = "jdbc:mysql://localhost:3306/mhns_enrollment_db";
		
		@SuppressWarnings("unused")
		//database username
		private String myDB_username = "root";
		@SuppressWarnings("unused")
		
		//database password
		private String myDB_PASSWORD = "";
                
                // To display the trachers
    public int teachers(Label displayinfo) throws ClassNotFoundException, SQLException{
        int numberOfteachers = 0;

        // Load MySQL driver
        Class.forName("com.mysql.jdbc.Driver");

        // Connect to the database using try-with-resources
        try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD);
             java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS UserID FROM usertable WHERE role = 'Teacher'")) {

            // Check if the result set has data
            if (rs.next()) {
              numberOfteachers = rs.getInt("UserID");
               displayinfo.setText(""+numberOfteachers);
                System.gc();
            }
        } // Resources are closed automatically due to try-with-resources

        return numberOfteachers;
        
    }
    public int grades(Label displayinfo2) throws ClassNotFoundException, SQLException{
        int numberOfScore = 0;

        // Load MySQL driver
        Class.forName("com.mysql.jdbc.Driver");

        // Connect to the database using try-with-resources
        try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD);
             java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT (FirstG + SecondG + ThirdG + FourthG) AS Total FROM gradingtable")) {

            // Check if the result set has data
            if (rs.next()) {
               numberOfScore = rs.getInt("Total");
               displayinfo2.setText(""+numberOfScore);
                     System.gc();
            }
        } // Resources are closed automatically due to try-with-resources

        return numberOfScore;
		
        
    }
    // To display the total student
    public int student(Label displayinfo1) throws ClassNotFoundException, SQLException{
         int numberOfteachers = 0;

        // Load MySQL driver
        Class.forName("com.mysql.jdbc.Driver");

        // Connect to the database using try-with-resources
        try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD);
             java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS StudentID FROM studentinformation")) {

            // Check if the result set has data
            if (rs.next()) {
              numberOfteachers = rs.getInt("StudentID");
               displayinfo1.setText(""+numberOfteachers);
                System.gc();
            }
        } // Resources are closed automatically due to try-with-resources

        return numberOfteachers;
    }
    
    // To display the report
    public int reports(Label displayinfo3) throws ClassNotFoundException, SQLException{
         int numberOfteachers = 0;

        // Load MySQL driver
        Class.forName("com.mysql.jdbc.Driver");

        // Connect to the database using try-with-resources
        try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD);
             java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS ReportID FROM reports")) {

            // Check if the result set has data
            if (rs.next()) {
              numberOfteachers = rs.getInt("ReportID");
               displayinfo3.setText(""+numberOfteachers);
                System.gc();
            }
        } // Resources are closed automatically due to try-with-resources

        return numberOfteachers;
    }
 public void checkroles(String user_receiver, Button adminbutton, Button reportbutton, Button dashboardbs, FontAwesomeIcon adminicon, FontAwesomeIcon reporticon, FontAwesomeIcon dashicon) {
     try (Connection connection = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
        String query = "SELECT role FROM usertable WHERE username = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user_receiver);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
                if (resultSet.next()) {
                    String role = resultSet.getString("role");
                    System.out.println("Role: " + role);
                    if (role.equals("Admin")) {
                        adminbutton.setVisible(true);
                        reportbutton.setVisible(true);
                        dashboardbs.setVisible(true);
                                         System.out.println("Role: " + role);
                    } else if (role.equals("Teacher")) {
                        adminbutton.setVisible(false);
                        reportbutton.setVisible(false);
                        dashboardbs.setVisible(false);
                        adminicon.setVisible(false);
                        reporticon.setVisible(false);
                        dashicon.setVisible(false);
                                         System.out.println("Role: " + role);
                    }
                } else {
                    // Username does not exist in the database
                    // Handle this case if needed
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception appropriately
    }
 }
}
