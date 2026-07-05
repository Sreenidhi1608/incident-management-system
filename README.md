# Incident Management System

A robust **Spring Boot REST API** for managing IT incidents. This project demonstrates backend development using Spring Boot, Spring Data JPA, MySQL, Swagger OpenAPI, and Maven. It includes complete CRUD operations, validation, searching, filtering, pagination, and sorting.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-green)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![License](https://img.shields.io/badge/License-MIT-blue)

---

# 📖 Project Overview

The **Incident Management System** is a RESTful backend application developed using **Spring Boot** to manage incidents efficiently.

The application provides APIs to:

- Create incidents
- Retrieve incidents
- Update incidents
- Delete incidents
- Search incidents
- Filter by Priority
- Filter by Status
- Pagination
- Sorting
- Input Validation
- API Documentation using Swagger

This project follows a layered architecture and is designed to demonstrate real-world backend development practices.

---

# 🚀 Technologies Used

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- Maven
- Swagger OpenAPI
- Jakarta Validation
- REST API

---

# ✨ Features

- ✅ Create Incident
- ✅ Get All Incidents
- ✅ Get Incident By ID
- ✅ Update Incident
- ✅ Delete Incident
- ✅ Search Incident by Title
- ✅ Filter by Priority
- ✅ Filter by Status
- ✅ Pagination
- ✅ Sorting
- ✅ Request Validation
- ✅ Exception Handling
- ✅ Swagger Documentation

---

# 🏗 Architecture

```text
                Client

                   │
                   ▼

        REST Controller Layer

                   │
                   ▼

           Service Layer

                   │
                   ▼

      Repository (Spring Data JPA)

                   │
                   ▼

            MySQL Database
```

---

# 📂 Project Structure

```text
incident-management-system
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.sreenidhi.incident_management
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── repository
│   │   │       ├── entity
│   │   │       ├── dto
│   │   │       ├── mapper
│   │   │       ├── exception
│   │   │       └── IncidentManagementApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── screenshots
│
├── pom.xml
│
└── README.md
```

---

# 📡 REST API Endpoints

| Method | Endpoint | Description |
|----------|--------------------------------------|----------------------------|
| POST | `/api/incidents` | Create Incident |
| GET | `/api/incidents` | Get All Incidents |
| GET | `/api/incidents/{id}` | Get Incident By ID |
| PUT | `/api/incidents/{id}` | Update Incident |
| DELETE | `/api/incidents/{id}` | Delete Incident |
| GET | `/api/incidents/search?title=` | Search by Title |
| GET | `/api/incidents/status/{status}` | Filter by Status |
| GET | `/api/incidents/priority/{priority}` | Filter by Priority |
| GET | `/api/incidents/page?page=0&size=5` | Pagination |
| GET | `/api/incidents/sort?field=id` | Sorting |

---

# ⚙️ How to Run

## 1. Clone the Repository

```bash
git clone https://github.com/Sreenidhi1608/incident-management-system.git
```

## 2. Open the Project

Open the project using:

- IntelliJ IDEA
- Eclipse
- VS Code

---

## 3. Configure MySQL

Create a database named:

```text
incident_management
```

Update the credentials inside:

```text
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/incident_management
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

---

## 4. Run the Project

Run

```
IncidentManagementApplication.java
```

Spring Boot will start on

```
http://localhost:8080
```

---

# 📘 Swagger API Documentation

After running the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger provides an interactive interface to test all REST APIs.

---

# 🗄 Database

**Database:** MySQL

**Database Name**

```
incident_management
```

---

# 📸 Screenshots

Swagger API screenshots are available inside the **screenshots** folder.

Example screenshots include:

- Create Incident
- Get All Incidents
- Get By ID
- Update Incident
- Delete Incident
- Search
- Filter
- Pagination
- Sorting
- Swagger UI

---

# 🔮 Future Improvements

- Spring Security Authentication
- JWT Authorization
- Role-Based Access Control (RBAC)
- Docker Support
- Cloud Deployment (AWS / Render)
- Email Notifications
- React Frontend
- Unit Testing
- Integration Testing

---

# 👨‍💻 Author

**Peddabodu Sai Sreenidhi**

GitHub:
> https://github.com/Sreenidhi1608

LinkedIn:
> *(Add your LinkedIn profile here.)*

---

# 📄 License

This project is developed for **learning, portfolio, and educational purposes**.

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.
