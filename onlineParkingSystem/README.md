# Online Parking System

## Introduction
The Online Parking System is a sophisticated web application designed to simplify the process of parking space management. It allows users to effortlessly find available parking spaces, make reservations, and process payments securely. This system benefits both users and administrators by providing a seamless and efficient parking experience.


## Video Walkthrough of the Project
[Watch Video](https://youtube.com)

## Features
- **User Registration:** Users can register for an account, providing their personal details and login credentials.
- **User Authentication:** Utilizes Spring Security for a secure authentication mechanism, ensuring user data safety.
- **Parking Space Management:** Admins can create, update, and delete parking spaces, managing location, availability, and pricing.
- **Reservation System:** Users can search for available parking spaces, make reservations, and manage expiration.
- **Payment Integration:** Integrated with a payment gateway for secure payment processing.
- **User Profiles:** Users can view and manage their profiles, including reservation history and account settings.
- **Admin Dashboard:** Provides administrators with a dashboard to monitor parking spaces, user accounts, and reservations.
- **Security:** Implements role-based access control to restrict unauthorized actions.
- **Logging and Error Handling:** Comprehensive logging and error handling for debugging and maintenance.
- **Documentation:** Clear and concise documentation for API endpoints, database schema, and system architecture.

## Design Decisions & Assumptions
- **Database:** MongoDB is chosen for its flexibility and scalability, ideal for managing various data types efficiently.
- **Authentication:** Utilizes Basic authentication and JWT (JSON Web Tokens) for secure API access and user authentication.
- **Frontend:** Assumes the presence of a separate frontend application developed using modern technologies like React or Angular.
- **Payment Gateway:** Assumes integration with a third-party payment gateway service (e.g., Stripe) for secure payment processing.

## Installation & Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/username/online-parking-system.git
   ```

2. Navigate to the project directory:
   ```bash
   cd online-parking-system
   ```

3. Build and run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application in your browser at `http://localhost:8080`.

## Usage
To make a reservation, users can follow these steps:
1. **Login:** Log in with your credentials or register for a new account.
2. **Search:** Search for available parking spaces based on location and date/time.
3. **Reserve:** Select a parking spot and make a reservation.
4. **Payment:** Proceed to payment and complete the transaction securely.
5. **Confirmation:** Receive a confirmation of your reservation with all relevant details.

## APIs Used
- **Spring Boot:** Backend framework for building RESTful APIs.
- **MongoDB:** NoSQL database for storing parking spaces, reservations, and user data.
- **JWT (JSON Web Tokens):** Token-based authentication for securing API endpoints.

## API Endpoints
- `GET /api/parking-spaces`: Retrieve a list of available parking spaces.
- `POST /api/reservations`: Create a new parking reservation.
- `GET /api/reservations/{id}`: Retrieve details of a specific reservation.
- `PUT /api/reservations/{id}`: Update an existing reservation (e.g., extend the reservation).
- `DELETE /api/reservations/{id}`: Cancel a reservation.

## Technology Stack
- **Java:** Backend programming language.
- **Spring Boot:** Backend framework for building robust and scalable applications.
- **MongoDB:** NoSQL database for flexible and efficient data storage.
- **Spring Security:** Provides authentication, authorization, and protection against common security exploits.
- **JWT (JSON Web Tokens):** Token-based authentication mechanism for secure API access.
- **Maven:** Project management and build automation tool.
- **Swagger:** API documentation tool for describing and visualizing RESTful APIs.
