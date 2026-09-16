package com.maurodelcore.user_profile_api.model;

public class User {

    // For this exercise, we will use final fields to ensure immutability.
    private final String username;
    private final int age;
    private final String email;
    private final String country;


    //Constructor
    public User(String username, int age, String email, String country) {
        this.username = username;
        this.age = age;
        this.email = email;
        this.country = country;
    }

    // Getters with no setters to ensure immutability
    // The point of not having setter and final fields
    // is because this app will not require changing the value once the user is created.
    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }
}
