package com.maurodelcore.user_profile_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserProfileApiApplication {

	/**
	 * <p>Create a Spring Boot application that defines a UserProfile model with details such as</p>
	 * <ul>
	 * <li>username</li>
	 * <li>age</li>
	 * <li>email</li>
	 * <li>country</li>
	 * </ul>
	 *
	 * <p>Store an array of hardcoded user profiles, initialized during app start using @PostConstruct.</p>
	 * <p>The application should expose two REST GET endpoints:</p>
	 *
	 * <ol>
	 * <li>Get a user profile by username (path parameter).</li>
	 * <li>List all user profiles filtered by age (query parameter).</li>
	 *</ol>
	 * <p>Both endpoints should return plain string responses, and no data storage or file system should be used.</p>
	 */


	public static void main(String[] args) {
		SpringApplication.run(UserProfileApiApplication.class, args);
	}

}
