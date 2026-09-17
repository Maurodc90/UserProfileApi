package com.maurodelcore.user_profile_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the User Profile API application.
 * <p>
 * Demonstrates a minimal Spring Boot REST API with hardcoded, in-memory
 * user data (no persistence layer). Exposes endpoints to look up a user
 * by username and to filter users by age.
 */
@SpringBootApplication
public class UserProfileApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileApiApplication.class, args);
	}
}