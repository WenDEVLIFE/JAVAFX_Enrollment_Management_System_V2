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
public class Subject {
    private final SimpleIntegerProperty SubjectID;
    private final SimpleStringProperty SubjectName;
    private final SimpleStringProperty Section;
    private final SimpleStringProperty timestarted;
        private final SimpleStringProperty timeended;
 

    public Subject(int SubjectID, String SubjectName, String Section, String  timestarted, String timeended) {
        this.SubjectID = new SimpleIntegerProperty(SubjectID);
        this.SubjectName = new SimpleStringProperty(SubjectName);
        this.Section = new SimpleStringProperty(Section);
        this. timestarted= new SimpleStringProperty( timestarted);
        this. timeended= new SimpleStringProperty( timeended);
    
          
    }

    public int getSubjectID() {
        return SubjectID.get();
    }

    public String getSubjectName() {
        return SubjectName.get();
    }

    public String getSection() {
        return Section.get();
    }

    public String getTimeStart() {
        return timestarted.get();
    }

    public String getTimeEnded() {
        return timeended.get();
    }


    public SimpleIntegerProperty getProperty(String propertyName) {
        switch (propertyName) {
            case "SubjectID":
                return SubjectID;
            default:
                throw new IllegalArgumentException("Invalid property name: " + propertyName);
        }
    }

    public String setSubjectName(String newValue) {
        // It seems like you are trying to set a new username, but the method is incomplete.
        // You may want to set the studentName property to the new value here.
        // If you want to return the previous username, you can use the following:
        String oldValue = SubjectName.get();
        SubjectName.set(newValue);
        return oldValue;
    }
    public void setSection(String newValue) {
    Section.set(newValue);
}

public void setTimeStart(String newValue) {
    timestarted.set(newValue);
}

public void setTimeEnded(String newValue) {
    timeended.set(newValue);
}
public void setSubjectID(int newSubjectID) {
        SubjectID.set(newSubjectID);
    }
    int getSubjectId() {
      return SubjectID.get();
    }
}