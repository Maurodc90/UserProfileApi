package com.maurodelcore.user_profile_api.controller;

import com.maurodelcore.user_profile_api.model.User;
import com.maurodelcore.user_profile_api.viewer.UserProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RestApiController {

    private final UserProfileService userProfileService;

    public RestApiController(UserProfileService userProfileService) {this.userProfileService = userProfileService;}

    @GetMapping("")
    public String getHelloWorld() {
        return "Hello World!";
    }

    @GetMapping("/user/{name}")
    public String filterUsers(@PathVariable String name) {
        return userProfileService.userlookup(name);
    }

    @GetMapping("/users")
    public ArrayList<User> getAllUsers() {
        return userProfileService.getAllUsers();
    }

    @GetMapping(value = "/users/age", produces = "text/plain")
    public String filterUsersByAge(@RequestParam(defaultValue = "0") int age) {
        return userProfileService.filterUsersByAge(age);
    }

}
