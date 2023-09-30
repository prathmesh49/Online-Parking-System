# Secure Online Voting System

## Introduction
The Secure Online Voting System is a secure and user-friendly platform that allows registered users to participate in elections or polls conveniently and securely. This document provides an overview of the key features, design decisions, installation instructions, and technologies used in the project.

## Deployed App
- [Secure Online Voting System](https://example.com)

## Video Walkthrough
- [Watch Video Walkthrough](https://example.com)

## Features
- User Registration and Authentication
- Ballot Creation and Management
- Vote Casting
- Vote Counting with Multi-threading
- Result Generation
- Security Measures (Encryption, Access Control, Audit Trails)
- Exception Handling
- Logging with Log4j
- Lombok for Code Simplification
- API Documentation with Swagger OpenAPI

## Design Decisions and Assumptions
- We assume that users will have a valid email address for account verification.
- Passwords are securely hashed and stored.
- Users can vote only once in the same election.
- The system uses Spring Security with JWT for authentication.
- Strong encryption techniques are used to protect user data and vote information.

## Installation & Getting Started
To run the Secure Online Voting System locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/secure-online-voting-system.git
   ```

2. Navigate to the project directory:
   ```bash
   cd secure-online-voting-system
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the application in your web browser at `http://localhost:8080`.

## Usage
- Register for an account using a valid email address.
- Log in to participate in active elections.
- Create and manage elections if you are an admin.
- Cast your vote in active elections.
- View election results after the voting period ends.

## APIs Used
- Spring Boot
- Spring Security with JWT Authentication
- Spring Data JPA
- Swagger OpenAPI for API Documentation
- Lombok for Code Simplification
- Log4j for Logging

## API Endpoints
- `POST /api/auth/register` - Register a new user account.
- `POST /api/auth/login` - Authenticate and log in a user.
- `POST /api/elections` - Create a new election (admin only).
- `GET /api/elections` - Get a list of all elections.
- `GET /api/elections/{electionId}` - Get details of a specific election.
- `POST /api/vote/{electionId}` - Cast a vote in an active election.
- `GET /api/results/{electionId}` - Get the results of an election (admin only).

## Technology Stack
- Java
- Spring Boot
- Spring Security with JWT Authentication
- Spring Data JPA
- Maven
- MySQL
- Swagger OpenAPI
- Log4j
- Lombok
