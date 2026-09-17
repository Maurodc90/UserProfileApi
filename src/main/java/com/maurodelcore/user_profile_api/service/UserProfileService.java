package com.maurodelcore.user_profile_api.service;

import com.maurodelcore.user_profile_api.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Holds the in-memory user profiles and provides lookup/filtering logic.
 * <p>
 * Data is hardcoded and populated once at startup via {@link PostConstruct};
 * no file system or database is used.
 */
@Service
public class UserProfileService {

    private final ArrayList<User> users = new ArrayList<>();

    private final User mauro = new User("mauro", 36, "mauro@email.com", "Italy");
    private final User elcin = new User("elcin", 32, "elcin@email.com", "Turkey");
    private final User john = new User("john", 32, "john@email.com", "USA");
    private final User josh = new User("josh", 32, "josh@email.com", "USA");

    /**
     * Populates the user list after Spring finishes constructing this bean.
     */
    @PostConstruct
    public void addUser() {
        users.add(mauro);
        users.add(elcin);
        users.add(john);
        users.add(josh);
    }

    /**
     * Searches for a single user by username.
     *
     * @param name the username to search for
     * @return the formatted user details, or "User not found"
     */
    public String userSearch(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return formatUser(user);
            }
        }
        return "User not found";
    }

    /**
     * Formats every stored user into a single newline-separated string.
     *
     * @return the formatted list of all users
     */
    public String allUsers() {
        StringBuilder userList = new StringBuilder();
        for (User user : users) {
            userList.append(formatUser(user)).append("\n");
        }
        return userList.toString();
    }

    /**
     * Returns the raw list of users matching the given age.
     *
     * @param age the age to filter by
     * @return a list of matching users (possibly empty)
     */
    public ArrayList<User> filterAge(int age) {
        ArrayList<User> filteredUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() == age) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }

    /**
     * Filters users by age and formats the result as a single string.
     *
     * @param age the age to filter by
     * @return the formatted list of matching users, or a not-found message
     */
    public String filterUsersByAge(int age) {
        ArrayList<User> filteredUsers = filterAge(age);
        if (filteredUsers.isEmpty()) {
            return "No users found with age " + age;
        }
        StringBuilder userList = new StringBuilder();
        for (User user : filteredUsers) {
            userList.append(formatUser(user)).append("\n");
        }
        return userList.toString();
    }

    /**
     * Formats a single user's details into a display string.
     *
     * @param user the user to format
     * @return the formatted string
     */
    private String formatUser(User user) {
        return "Name: " + user.getUsername() + ". Age: " + user.getAge()
                + ". Email: " + user.getEmail() + ". Country: " + user.getCountry();
    }
}