# Inventory Management Tool (IMT)

A backend RESTful API built with **Spring Boot**, secured with **JWT authentication**, and connected to a **MySQL** database.  
This project supports role-based access control and provides APIs for managing products and inventory.

---

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Setup & Installation](#setup--installation)
- [Database Schema](#database-schema)
- [API Documentation](#api-documentation)
- [Usage](#usage)
- [Testing](#testing)
- [Future Scope](#future-scope)
- [Acknowledgments](#acknowledgments)

---

## Features
- User registration and login with JWT-based security  
- Role-based access control (Admin / User)  
- CRUD operations on products and inventory management  
- Secure password storage with BCrypt hashing  
- REST APIs documented with Swagger/OpenAPI  

---

## Tech Stack
- **Backend:** Java, Spring Boot  
- **Security:** Spring Security, JWT (JSON Web Tokens)  
- **Database:** MySQL  
- **Build Tool:** Maven  
- **API Testing:** Postman  
- **Version Control:** Git, GitHub  

---

## Setup & Installation

### Prerequisites
- Java JDK 11 or above  
- MySQL Server installed and running  
- Maven installed  
- Git installed  

### Steps
1. Clone this repository:  
```
git clone https://github.com/USERNAME/REPO_NAME.git
cd REPO_NAME
```
2. Configure MySQL database:
Create a new database (e.g., inventorydb)
Update the application.properties file with your MySQL credentials:
```
spring.datasource.url=jdbc:mysql://localhost:3306/inventorydb
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```
3. Build and run the application:
```
mvn clean install
mvn spring-boot:run
```
4. Access Swagger UI for API documentation:
```
http://localhost:8080/swagger-ui.html
```
Database Schema
| Table       | Description                       |
| ----------- | --------------------------------- |
| `users`     | Stores user account information   |
| `roles`     | Stores roles (ADMIN, USER)        |
| `products`  | Stores product details            |
| `inventory` | Tracks stock levels for products  |
| `orders`    | (If applicable) Stores order info |


API Documentation
Authentication:

/auth/register – Register new users

/auth/login – Login and receive JWT token

Product Management (Admin only):

/products – Create, Read, Update, Delete products

Inventory Management:

/inventory – View and update product stock

User Operations:

View products and inventory (read-only)

Refer to Swagger UI for full API details.

Usage
Register new users (POST /auth/register)

Login (POST /auth/login) to get JWT token

Include JWT token in Authorization: Bearer <token> header for protected endpoints

Admin users can manage products and inventory

Normal users can view product details

Testing
Use the Postman collection provided (postman_collection.json) to test APIs

Run unit tests via Maven:
```
mvn test
Future Scope
Implement order and sales management

Add reporting and analytics dashboards
Integrate role-based UI frontend
Support bulk import/export of product data
Add notifications for low stock alerts

## **Acknowledgments**
Spring Boot and Spring Security documentation
Open source libraries used in the project
Community tutorials and examples
