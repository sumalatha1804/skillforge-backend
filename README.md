# SkillForge Backend

SkillForge is a personal career growth platform built with Java and Spring Boot.

## Technologies

Java 21, Spring Boot, Spring Data JPA, Hibernate, MySQL, REST APIs, Maven

## Database

The application uses a local MySQL database.

Database:
skillforge

MySQL:
localhost:3306

Create the database only if it does not already exist:

CREATE DATABASE skillforge;

## Configuration

The backend uses the following local MySQL configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/skillforge
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8082

Replace YOUR_MYSQL_PASSWORD with your local MySQL password.

## Running the Backend

1. Start MySQL Server.
2. Open the project in Eclipse, IntelliJ IDEA, or VS Code.
3. Run SkillforgeApplication.java.
4. The backend runs at:

http://localhost:8082

## API Testing

APIs can be tested using Postman.

Backend URL:

http://localhost:8082

## Features

- User registration
- User login
- REST API integration
- MySQL database integration
- JPA and Hibernate
- Career growth platform functionality

## Frontend

The SkillForge frontend is developed using React.js.

Frontend runs locally at:

http://localhost:3000

## Author

Sumalatha
