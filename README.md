# Smart EV Charging Station Allocator

## Abstract
This project is a web-based application designed to manage electric vehicle (EV) charging stations. It enables EV users to find nearby stations, view available slots, reserve a slot, and simulate a charging session with billing.

## Problem Statement
The increasing adoption of EVs requires efficient charging infrastructure. Users often face difficulties finding available charging slots and tracking their charging usage and billing.

## Objectives
- Provide a platform for users to find and book EV charging slots.
- Simulate the charging process and automatically calculate energy and billing.
- Offer an administrative dashboard to manage stations, users, and vehicles.

## Features
- **Authentication**: User registration and login.
- **Dashboard**: Real-time statistics for stations, availability, and active sessions.
- **Station Management**: Add, view, edit, search, and delete stations.
- **Vehicle & User Management**: Link EVs to registered users.
- **Booking System**: Reserve available slots at stations.
- **Charging Simulation**: Start/Stop charging, energy computation, billing receipt.
- **Responsive UI**: Modern, EV-themed HTML/CSS interface.

## Technologies Used
- **Backend**: Java 17, Spring Boot, Spring Data JPA
- **Database**: MySQL
- **Frontend**: HTML5, CSS3, Bootstrap 5, Thymeleaf
- **Build Tool**: Maven

## System Architecture
Follows the standard MVC layered architecture:
- `Controller`: Handles HTTP requests (Spring MVC).
- `Service`: Contains business logic (Booking simulation, billing).
- `Repository`: Interfaces with MySQL (Spring Data JPA).
- `Model`: Java entities mapped to database tables.

## OOP Concepts
- **Encapsulation**: Private fields with public getters/setters in entities.
- **Inheritance**: `StationManager` extends `EVUser`.
- **Exception Handling**: Global exception handler and custom exceptions (`StationNotFoundException`, etc.).

## Setup Instructions
1. Install Java 17 and Maven.
2. Install MySQL Server. Create a database `smart_ev_allocator`.
3. Update `application.properties` with your MySQL credentials.
4. Run `mvn spring-boot:run` to start the application.
5. Access the app at `http://localhost:8080`.
6. Sample data is automatically inserted on startup.
