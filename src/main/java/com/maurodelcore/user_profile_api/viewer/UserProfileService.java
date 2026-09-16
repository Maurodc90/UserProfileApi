package com.maurodelcore.user_profile_api.viewer;

import com.maurodelcore.user_profile_api.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Service
public class UserProfileService {


    ArrayList<User> users = new ArrayList<>();
    //String username, int age, String email, String country
    User mauro = new User("mauro", 36, "mauro@email.com", "Italy");
    User elcin = new User("elcin", 32, "elcin@email.com", "Turkey");
    User john = new User("john", 32, "john@email.com", "USA");
    User josh = new User("josh", 32, "josh@email.com", "USA");


    @PostConstruct
    public void addUser() {
        users.add(mauro);
        users.add(elcin);
        users.add(john);
        users.add(josh);
    }

    public String userlookup(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return "Name: " + user.getUsername() + ". Age: " + user.getAge() + ". Email: " + user.getEmail() + ". Country: " + user.getCountry();
            }
        }
        return "User not found";
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public ArrayList<User> filterAge(int age) {
        ArrayList<User> filteredUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() == age) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }

    public String filterUsersByAge(int age) {
        ArrayList<User> filteredUsers = filterAge(age);
        StringBuilder userList = new StringBuilder();
        if (filteredUsers.isEmpty()) {
            return "No users found with age " + age;
        }
        for (User user : filteredUsers) {
            userList.append("Name: ").append(user.getUsername()).append(". Age: ").append(user.getAge()).append(". Email: ").append(user.getEmail()).append(". Country: ").append(user.getCountry()).append("\n");
        }
        return userList.toString();
    }
}
