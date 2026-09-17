package com.maurodelcore.user_profile_api.model;

/**
 * Represents an immutable user profile.
 * <p>
 * Fields are {@code final} with no setters, since this application never
 * needs to modify a user's details after creation.
 */
public class User {

    private final String username;
    private final int age;
    private final String email;
    private final String country;

    /**
     * Creates a new immutable user profile.
     *
     * @param username the user's username
     * @param age      the user's age
     * @param email    the user's email address
     * @param country  the user's country
     */
    public User(String username, int age, String email, String country) {
        this.username = username;
        this.age = age;
        this.email = email;
        this.country = country;
    }

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