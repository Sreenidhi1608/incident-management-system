# Incident Management System

## Overview
A Spring Boot REST API for managing IT incidents with complete CRUD operations, search, filtering, pagination, sorting, and Swagger API documentation.

---

## Features

- Create Incident
- Get All Incidents
- Get Incident by ID
- Update Incident
- Delete Incident
- Search Incident by Title
- Filter by Status
- Filter by Priority
- Pagination
- Sorting
- Swagger UI Documentation

---

## Tech Stack

- Java 21
- Spring Boot 3
- Spring Data JPA
- MySQL
- Maven
- Swagger OpenAPI

---

## API Endpoints

### CRUD

POST /api/incidents

GET /api/incidents

GET /api/incidents/{id}

PUT /api/incidents/{id}

DELETE /api/incidents/{id}

### Search & Filter

GET /api/incidents/search?title=

GET /api/incidents/status/{status}

GET /api/incidents/priority/{priority}

### Pagination

GET /api/incidents/page?page=0&size=5

### Sorting

GET /api/incidents/sort?field=priority

---

## Database

MySQL

---

## Swagger API

http://localhost:8080/swagger-ui/index.html

---

## Author

**PEDDABODU SAI SREENIDHI**

GitHub:
https://github.com/Sreenidhi1608
