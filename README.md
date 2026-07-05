# Incident Management System

A Spring Boot REST API project for managing incidents with complete CRUD operations, filtering, pagination, sorting, and API documentation using Swagger.

## Technologies Used

* Java 21
* Spring Boot 3
* Spring Data JPA
* MySQL
* Swagger OpenAPI
* Maven
* Jakarta Validation

## Features

* Create Incident
* Get All Incidents
* Get Incident by ID
* Update Incident
* Delete Incident
* Search by Title
* Filter by Priority
* Filter by Status
* Pagination
* Sorting
* Input Validation
* Swagger API Documentation

## Project Structure

```
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── mapper
 └── exception
```

## API Endpoints

| Method | Endpoint                           |
| ------ | ---------------------------------- |
| POST   | /api/incidents                     |
| GET    | /api/incidents                     |
| GET    | /api/incidents/{id}                |
| PUT    | /api/incidents/{id}                |
| DELETE | /api/incidents/{id}                |
| GET    | /api/incidents/search              |
| GET    | /api/incidents/priority/{priority} |
| GET    | /api/incidents/status/{status}     |
| GET    | /api/incidents/page                |
| GET    | /api/incidents/sort                |

## Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

## Database

MySQL Database

Database Name:

```
incident_management
```

## Screenshots

Swagger API screenshots are available in the `screenshots` folder.

## Author

Peddabodu Sai Sreenidhi
