/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

/**
 *
 * @author Administrator
 */
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty username;
    private final SimpleStringProperty role;

    public User(int id, String username, String role) {
        this.id = new SimpleIntegerProperty(id);
        this.username = new SimpleStringProperty(username);
        this.role = new SimpleStringProperty(role);
    }

    public int getId() {
        return id.get();
        
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String newUsername) {
        username.set(newUsername);
    }

    public String getRole() {
        return role.get();
    }

    public void setRole(String newRole) {
        role.set(newRole);
    }
}


