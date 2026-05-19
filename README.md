# RESTful Bookstore API

## 📚 Project Overview
An enterprise-level REST API system for managing a Bookstore. Built using Spring Boot 3 and Java 17. The system allows management of Books, Authors, Categories, and Inventory. It includes advanced features like JWT Authentication, Role-based Access, Pagination, Sorting, Global Exception Handling, Request Validation, and an interactive Swagger UI.

---

## 🏗 Architecture Explanation
The application is built using a **Layered Clean Architecture** and **DTO Pattern**.
1. **Controller Layer**: Handles incoming HTTP requests and maps them to appropriate services.
2. **Service Layer**: Contains business logic.
3. **Repository Layer**: Handles data access and communication with the H2 Database using Spring Data JPA.
4. **Entity Layer**: Represents the Database tables.
5. **DTO (Data Transfer Object) Layer**: Used to transfer data between the client and server without exposing internal entity models.
6. **Mapper Layer**: Converts DTOs to Entities and vice-versa.
7. **Exception Layer**: Global centralized exception handler to provide standard API error responses.
8. **Config/Security Layer**: Handles application configurations, Swagger documentation, and JWT Security configurations.

---

## ⚙️ Advanced Features Implemented
1. **JWT Authentication & Authorization**: Secure API using token-based auth.
2. **Role-Based Access**: Admins can Create/Update/Delete. Users can view.
3. **Global Exception Handling**: Returns consistent `ValidationErrorResponse`.
4. **Request Validation**: Incoming DTOs are validated (`@NotBlank`, `@Positive`, etc.).
5. **Pagination & Sorting**: Support for paginated lists and custom sorting parameters.
6. **Testing**: Includes JUnit Mockito tests and MockMvc integration tests.

---

## 🌐 API Documentation / Endpoint Table

### 1. Authentication
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/api/v1/auth/register` | Register new user | Public |
| POST | `/api/v1/auth/login` | Login and get JWT | Public |

### 2. Books
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/v1/books` | Get all books (paginated) | Public |
| GET | `/api/v1/books/{id}` | Get book by ID | Public |
| GET | `/api/v1/books/search?title={title}` | Search books by title | Public |
| GET | `/api/v1/books/category/{categoryId}`| Filter books by category | Public |
| GET | `/api/v1/books/author/{authorId}` | Filter books by author | Public |
| POST | `/api/v1/books` | Create a new book | ADMIN |
| PUT | `/api/v1/books/{id}` | Update a book | ADMIN |
| DELETE | `/api/v1/books/{id}` | Delete a book | ADMIN |

### 3. Authors & Categories
Similar endpoints exist under `/api/v1/authors` and `/api/v1/categories`. GET methods are public, while POST/PUT/DELETE are restricted to ADMIN role.

---

## 🚀 Setup Instructions

### Prerequisites
- JDK 17
- Maven 3.8+
- An IDE (IntelliJ, Eclipse, VS Code)

### Terminal Commands to Run
Open PowerShell or Terminal and navigate to the project directory:

```powershell
# Clean and compile the project
mvn clean compile

# Run tests
mvn test

# Package the application
mvn clean package -DskipTests

# Run the Spring Boot Application
mvn spring-boot:run
```
*(If Maven is not globally installed, you can use `./mvnw` instead of `mvn` if you generate the Maven Wrapper)*

---

## 🧪 Postman & Testing Guide

### 1. Accessing Swagger UI
When the app is running on port 8080, open your browser:
- **Swagger URL:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **H2 Console:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console) (JDBC URL: `jdbc:h2:mem:bookstoredb`)

### 2. Testing with Postman
**Step 1: Login**
- Send `POST` request to `http://localhost:8080/api/v1/auth/login`
- Body (JSON):
```json
{
  "username": "admin",
  "password": "password123"
}
```
- Copy the `token` from the response.

**Step 2: Access Secured Endpoint**
- Add the token in Postman:
  - Go to **Authorization** tab.
  - Select **Bearer Token**.
  - Paste the copied token.
- Send `POST` request to `http://localhost:8080/api/v1/books` with body:
```json
{
  "title": "New Book",
  "isbn": "1122334455",
  "description": "Book desc",
  "price": 25.50,
  "stockQuantity": 5,
  "authorId": 1,
  "categoryId": 1
}
```

---

## 🔮 Future Improvements
1. Implement Redis Caching for `/api/v1/books` and `/api/v1/categories`.
2. Add API Rate Limiting using Bucket4j.
3. Integrate Docker and provide a `Dockerfile` & `docker-compose.yml`.
4. Add Audit Logging using Aspect Oriented Programming (AOP).

---

## 📸 Screenshots Placeholders
![Swagger UI](placeholder_for_swagger_ui_screenshot.png)
![Postman Test](placeholder_for_postman_test_screenshot.png)
![H2 Database](placeholder_for_h2_screenshot.png)
