package com.maurodelcore.user_profile_api.controller;

import com.maurodelcore.user_profile_api.service.UserProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller exposing user profile endpoints.
 * <p>
 * All logic (lookup, filtering, formatting) is delegated to
 * {@link UserProfileService}; this class only handles routing.
 */
@RestController
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("")
    public String getHelloWorld() {
        return "Hello World!";
    }

    /**
     * Looks up a single user by username.
     *
     * @param name the username to search for, taken from the URL path
     * @return the matching user's details, or a not-found message
     */
    @GetMapping(value = "/user/{name}", produces = "text/plain")
    public String getUserByUsername(@PathVariable String name) {
        return userProfileService.userSearch(name);
    }

    /**
     * Returns every stored user profile.
     *
     * @return a newline-separated list of all users
     */
    @GetMapping(value = "/users", produces = "text/plain")
    public String getAllUsers() {
        return userProfileService.allUsers();
    }

    /**
     * Returns all users matching the given age.
     *
     * @param age the age to filter by, passed as a query parameter (defaults to 0)
     * @return a newline-separated list of matching users, or a not-found message
     */
    @GetMapping(value = "/users/age", produces = "text/plain")
    public String filterUsersByAge(@RequestParam(defaultValue = "0") int age) {
        return userProfileService.filterUsersByAge(age);
    }
}