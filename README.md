##  Book Management API

A Spring Boot REST API for managing books with CRUD operations.  
This project demonstrates backend development using Java, Spring Boot, and RESTful services.

---

##  Features


- Add new books
- Get all books
- Get book by ID
- Update book details
- Delete books
- REST API architecture
- Exception handling
  
---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL 
- Maven

---


## How to Run the Project

### 1. Clone the Repository

```bash
https://github.com/vishal-backend/book-management-api.git
```

### 2. Open Project

Open in IntelliJ IDEA or VS Code.

---

### 3. Create Database

```sql
CREATE DATABASE book_author_db;
```

---

### 4. Configure application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vishal
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 5. Install Dependencies

```bash
mvn clean install
```

OR  run the main class from IDE.

---

### 6. Run Project

```bash
mvn spring-boot:run
```

---

## API Base URL

```bash
http://localhost:8080
```
---

##  API Endpoints

----
```
## Author APIs

GET /authors  
GET /authors/{id}  
POST /authors  
PUT /authors/{id}  
DELETE /authors/{id}  
```
---

```
## Book APIs

GET /books  
GET /books/{id}  
GET /books/author/{author_Id}  
POST /books/{author_id}  
PUT /books/{id}  
DELETE /books/{id}
```

---

