# Online Book Store

## Introduction
The Online Book Store is a web application developed using Java, Spring Boot, and REST API technologies. It provides users with the ability to browse, search, and purchase books online while ensuring secure user profiles and a seamless shopping experience.

## Deployed App
[Online Book Store](https://example-bookstore.com)

## Video Walkthrough
[Watch Video Walkthrough](https://video-link.example)

## Features
- User authentication and authorization
- Browse and search for books
- Add books to the shopping cart
- Remove books from the cart
- Checkout and complete orders
- Secure user profiles
- Seamless shopping experience

## Design Decisions and Assumptions
- The application uses Spring Security for user authentication and authorization.
- User profiles include features like profile images and about me sections.
- The database schema includes tables for books, users, orders, and user profiles.
- Many-to-many relationships between books and orders are managed through the `order_items` table.
- Shopping cart functionality is implemented to allow users to add and remove books.
- Orders are created when users proceed to checkout.
- The application assumes a MySQL database for data storage.

## Installation & Getting Started
To run the Online Book Store locally, follow these steps:

## 1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/online-book-store.git
   cd online-book-store
   ```

Set up the MySQL database and configure the application.properties file with the database credentials.

## Build the project using Maven:

    
    Copy code
    mvn clean install
    

Run the Spring Boot application:

    
    Copy code
    mvn spring-boot:run
    Access the application in your web browser at http://localhost:8080.

Usage

    
    To use the Online Book Store:

Create an account or log in if you already have one.
Browse and search for books by title, author, or genre.
Add books to your shopping cart.
Review and remove books from the cart.
Proceed to checkout to complete your order.
View and edit your user profile.

## APIs Used
No external APIs are used in this application.

## API Endpoints
For the backend API, the following endpoints are available:

- GET /api/books - Retrieve a list of all books.
- GET /api/books/{bookId} - Retrieve details of a specific book.
- POST /api/cart/add - Add a book to the shopping cart.
- POST /api/cart/remove - Remove a book from the shopping cart.
- POST /api/cart/checkout - Checkout and complete an order.
- GET /api/user/profile - Retrieve the user's profile information.
- PUT /api/user/profile - Update the user's profile information.

## Technology Stack
The Online Book Store is built using the following technologies:

Java
Spring Boot
Spring Security
Spring Data JPA
Hibernate
Maven
MySQL
HTML, CSS, and JavaScript (for the frontend)
