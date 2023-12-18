/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Administrator
 */
public class Grading {
    private final SimpleIntegerProperty subjectID;
    private final SimpleStringProperty studentName;
    private final SimpleStringProperty section;
    private final SimpleIntegerProperty firstGrading;
    private final SimpleIntegerProperty secondGrading;
    private final SimpleIntegerProperty thirdGrading;
    private final SimpleIntegerProperty forthGrading;
    private final SimpleIntegerProperty total;
    private final SimpleIntegerProperty StudentID;

    public Grading(int subjectID, String studentName, String section, int firstGrading, int secondGrading, int thirdGrading, int forthGrading, int total, int StudentID) {
        this.subjectID = new SimpleIntegerProperty(subjectID);
        this.studentName = new SimpleStringProperty(studentName);
        this.section = new SimpleStringProperty(section);
        this.firstGrading = new SimpleIntegerProperty(firstGrading);
        this.secondGrading = new SimpleIntegerProperty(secondGrading);
        this.thirdGrading = new SimpleIntegerProperty(thirdGrading);
        this.forthGrading = new SimpleIntegerProperty(forthGrading);
        this.StudentID = new SimpleIntegerProperty(StudentID);
        this.total = new SimpleIntegerProperty(calculateTotal(firstGrading, secondGrading, thirdGrading, forthGrading));
    }

    public int getSubjectID() {
        return subjectID.get();
    }

    public String getStudentName() {
        return studentName.get();
    }

    public String getSection() {
        return section.get();
    }

    public int getFirstGrading() {
        return firstGrading.get();
    }

    public int getSecondGrading() {
        return secondGrading.get();
    }

    public int getThirdGrading() {
        return thirdGrading.get();
    }

    public int getForthGrading() {
        return forthGrading.get();
    }

    public int getTotal() {
        return total.get();
    }

    public void setStudentName(String newValue) {
        studentName.set(newValue);
    }

    public void setSection(String newValue) {
        section.set(newValue);
    }

    public void setFirstGrading(int newValue) {
        firstGrading.set(newValue);
        updateTotal();
    }

    public void setSecondGrading(int newValue) {
        secondGrading.set(newValue);
        updateTotal();
    }

    public void setThirdGrading(int newValue) {
        thirdGrading.set(newValue);
        updateTotal();
    }

    public void setForthGrading(int newValue) {
        forthGrading.set(newValue);
        updateTotal();
    }

    private int calculateTotal(int first, int second, int third, int forth) {
        return (first + second + third + forth) / 4;
    }

    private void updateTotal() {
        total.set(calculateTotal(firstGrading.get(), secondGrading.get(), thirdGrading.get(), forthGrading.get()));
    }

   public int getStudentID() {
    return StudentID.get();
}
}
