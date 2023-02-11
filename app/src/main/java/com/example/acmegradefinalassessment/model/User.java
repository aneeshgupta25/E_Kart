package com.example.acmegradefinalassessment.model;

public class User {
    private String name, email, password;
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    //Getters will ensure the privacy of data, since String is an Immutable class, we will not be able to change the same object elsewhere..
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
