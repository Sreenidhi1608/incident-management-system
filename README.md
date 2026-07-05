# Incident Management System

A RESTful Incident Management System built using Spring Boot.

## Features

- Create Incident
- Get All Incidents
- Get Incident By ID
- Update Incident
- Delete Incident
- Search by Title
- Filter by Status
- Filter by Priority
- Pagination
- Sorting
- Validation
- Global Exception Handling
- Swagger API Documentation
- Unit Testing
- Repository Testing

## Technologies Used

- Java 21
- Spring Boot 3
- Spring Data JPA
- MySQL
- H2 Database
- Maven
- JUnit 5
- Mockito
- Swagger (OpenAPI)

## API Endpoints

| Method | Endpoint |
|---------|----------|
| POST | /api/incidents |
| GET | /api/incidents |
| GET | /api/incidents/{id} |
| PUT | /api/incidents/{id} |
| DELETE | /api/incidents/{id} |
| GET | /api/incidents/search |
| GET | /api/incidents/status/{status} |
| GET | /api/incidents/priority/{priority} |
| GET | /api/incidents/page |
| GET | /api/incidents/sort |

## Running the Project

```bash
mvn clean install
mvn spring-boot:run
```

Server runs at:

```
http://localhost:8080
```

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

## Testing

Run:

```bash
mvn clean test
```

Current Test Results

- Total Tests : 26
- Passed : 26
- Failed : 0

## Author

Sai Sreenidhi