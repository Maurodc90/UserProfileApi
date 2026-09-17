# UserProfileAPI

A Spring Boot REST API demonstrating `@PathVariable` and `@RequestParam` usage with in-memory, hardcoded data. No database or file system involved.

## Endpoints

- `GET /user/{name}` — look up a single user profile by username
- `GET /users` — list all user profiles
- `GET /users/age?age={age}` — list all user profiles matching a given age

## Concepts demonstrated

- `@RestController`, `@GetMapping`
- `@PathVariable` vs `@RequestParam`
- `@PostConstruct` for startup initialization
- Constructor-based dependency injection
- Separation of concerns: Controller (routing) vs Service (business logic) vs Model (data)
- Immutable model objects (final fields, no setters)

## Tech stack

Java 21, Spring Boot 4.1.1, Gradle