/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Administrator
 */


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private final SimpleIntegerProperty studentID;
    private final SimpleStringProperty studentName;
    private final SimpleStringProperty studentAddress;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty age;
    private final SimpleStringProperty PhoneNum;  // Corrected variable name to follow Java naming conventions
     private final SimpleStringProperty BirthYear; 

    public Student(int studentID, String studentName, String studentAddress, String gender, String age, String phoneNum, String BirthYear) {
        this.studentID = new SimpleIntegerProperty(studentID);
        this.studentName = new SimpleStringProperty(studentName);
        this.studentAddress = new SimpleStringProperty(studentAddress);
        this.gender = new SimpleStringProperty(gender);
        this.age = new SimpleStringProperty(age);
        this.BirthYear = new SimpleStringProperty(BirthYear);
         this.PhoneNum = new SimpleStringProperty(phoneNum);   // Corrected variable name to match constructor parameter
          
    }

    public int getStudentID() {
        return studentID.get();
    }

    public String getStudentName() {
        return studentName.get();
    }

    public String getStudentAddress() {
        return studentAddress.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getAge() {
        return age.get();
    }

  public String getPhoneNum() {
    return PhoneNum.get();
}
   public String getBirthYear() {
    return BirthYear.get();
}

    public SimpleIntegerProperty getProperty(String propertyName) {
        switch (propertyName) {
            case "studentID":
                return studentID;
            default:
                throw new IllegalArgumentException("Invalid property name: " + propertyName);
        }
    }

    public String setUsername(String newValue) {
        // It seems like you are trying to set a new username, but the method is incomplete.
        // You may want to set the studentName property to the new value here.
        // If you want to return the previous username, you can use the following:
        String oldValue = studentName.get();
        studentName.set(newValue);
        return oldValue;
    }

    int getId() {
      return studentID.get();
    }
}