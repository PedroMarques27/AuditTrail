# Audit Trail v1.0.1 Application

## Overview
The Audit Trail application is designed to log and track the interactions between various systems, including requests and responses, with detailed metadata. This application is particularly useful for monitoring, debugging, and auditing system operations.  
This is a simple application that I will use in future projects as a method of monitoring my systems  

## Table of Contents
- [Technologies Used](#technologies-used)
- [Entities](#entities)
- [Operations](#operations)
- [Swagger Documentation](#swagger-documentation)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (for testing purposes)
- Swagger UI for API documentation

## Entities
The following entities are defined in the application:

### 1. `Log`
Represents an individual log entry.
- **Fields**:
  - `id`: Unique identifier for the log entry.
  - `systemName`: The name of the system generating the log.
  - `level`: The severity level of the log (e.g., DEBUG, ERROR).
  - `message`: The log message.
  - `timestamp`: The time when the log entry was created.
  - `requestInformation`: Contains details about the request (method, URL, client IP, etc.).
  - `responseInformation`: Contains details about the response (status code, response body).

### 2. `Platform`
Represents the systems involved in the logging process.
- **Fields**:
  - `id`: Unique identifier for the platform.
  - `systemName`: Name of the platform.
  - `host`: The host URL of the platform.
  - `healthEndpoint`: Endpoint to check the health status of the platform.

### 3. `RequestInformation`
Contains details about the request made to the system.
- **Fields**:
  - `method`: HTTP method (GET, POST, etc.).
  - `url`: The URL of the request.
  - `clientIp`: IP address of the client making the request.
  - `headers`: Request headers.
  - `requestBody`: Body of the request.

### 4. `ResponseInformation`
Contains details about the response from the system.
- **Fields**:
  - `statusCode`: HTTP status code.
  - `responseBody`: Body of the response.

### 5. `Level`
Enumerates the different logging levels used in the application.
- **Values**:
  - INITIALIZATION
  - TERMINATION
  - DEBUG
  - INFORMATION
  - WARNING
  - ERROR
  - FATAL

### 6. `HttpCode`
Enumerates common HTTP methods.
- **Values**:
  - GET
  - POST
  - PUT
  - DELETE

## Operations
The application provides the following operations through its API:

1. **Create Log Entry**: 
   - **Endpoint**: `POST /logs`
   - **Request Body**: JSON object containing the log details.
   - **Response**: Created log entry.

2. **Retrieve Log Entries**: 
   - **Endpoint**: `GET /logs`
   - **Response**: List of all log entries.

3. **Retrieve Log Entry by ID**:
   - **Endpoint**: `GET /logs/{id}`
   - **Response**: Log entry details.

4. **Delete Log Entry**:
   - **Endpoint**: `DELETE /logs/{id}`
   - **Response**: Confirmation of deletion.

5. **Create Platform Entry**: 
   - **Endpoint**: `POST /platforms`
   - **Request Body**: JSON object containing platform details.
   - **Response**: Created platform entry.

6. **Retrieve Platform Entries**: 
   - **Endpoint**: `GET /platforms`
   - **Response**: List of all platform entries.

7. **Retrieve Platform Entry by ID**:
   - **Endpoint**: `GET /platforms/{id}`
   - **Response**: Platform entry details.

8. **Delete Platform Entry**:
   - **Endpoint**: `DELETE /platforms/{id}`
   - **Response**: Confirmation of deletion.

## Swagger Documentation
Swagger UI is available for API documentation and testing. You can access it at: [Swagger](http://localhost:8080/swagger-ui/index.html)  

This interface provides a user-friendly way to explore and interact with the API endpoints defined in the application.

## Setup and Installation
To set up and run the application, follow these steps:

1. Clone the repository;
2. Open Terminal inside the AuditTrail folder
2. Build the Project ```./mvnw clean install```
3. Run ```java -jar target/audittrail-1.0.1.jar```

   
## Usage
Use the provided API endpoints to log information or retrieve logs/platform details. Swagger UI can be a helpful tool for testing these operations.
