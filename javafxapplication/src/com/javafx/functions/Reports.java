/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Reports {
    private final SimpleIntegerProperty reportID;
    private final SimpleStringProperty username;
    private final SimpleStringProperty date;
    private final SimpleStringProperty activity;

    public Reports(int reportID, String username, String date, String activity) {
        this.reportID = new SimpleIntegerProperty(reportID);
        this.username = new SimpleStringProperty(username);
        this.date = new SimpleStringProperty(date);
        this.activity = new SimpleStringProperty(activity);
    }

    public int getReportID() {
        return reportID.get();
    }

    public String getUsername() {
        return username.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getActivity() {
        return activity.get();
    }

    public SimpleIntegerProperty getProperty(String propertyName) {
        switch (propertyName) {
            case "reportID":
                return reportID;
            default:
                throw new IllegalArgumentException("Invalid property name: " + propertyName);
        }
    }

    public String setUsername(String newValue) {
        String oldValue = username.get();
        username.set(newValue);
        return oldValue;
    }

    public int getId() {
        return reportID.get();
    }
}