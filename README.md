# Orange Food - Backend API Services

A robust, secure, and modern RESTful API backend for a food delivery and restaurant ordering system, built on top of **Spring Boot 3** and **Java 18**.

---

## 🚀 Key Features

* **User Authentication & RBAC**: Fully secure JWT-based authentication (Login, Register, Token Introspection, Token Refresh, and Logout) with granular Role-Based Access Control (RBAC).
* **Restaurant Catalog**: APIs to register new restaurants (with image upload support), search restaurants by keyword, retrieve details, and edit information.
* **Menu & Category Management**: Dynamic classification of food items into categories, customizable pricing, delivery times, and menu media uploads.
* **Order Processing**: Simple and efficient APIs for handling customer ordering workflows.
* **Hybrid Storage Integration**: Flexible file upload system with local disk storage fallback and direct AWS S3 integration for cloud media assets.

---

## 🛠️ Tech Stack

* **Framework**: Spring Boot 3.1.3, Spring Security, Spring MVC
* **Database & ORM**: MySQL, Hibernate, Spring Data JPA
* **Security & Tokens**: OAuth2 Resource Server, Nimbus JOSE + JWT
* **Utilities**: Lombok, MapStruct, ModelMapper, Jackson
* **Cloud & Media**: AWS SDK S3 v2, Commons FileUpload
* **Testing**: JUnit 5, Mockito, Testcontainers (for MySQL database isolation), H2 Database
* **Code Quality**: Spotless (Palantir formatting style), JaCoCo (Coverage reporting)

---

## 📋 Prerequisites

Before running the application, make sure you have the following installed:
* **Java Development Kit (JDK) 18** or higher
* **Apache Maven 3.8+** (or use the provided `./mvnw` wrapper)
* **MySQL Server 8.0+**

---

## ⚙️ Configuration & Environment Setup

### 1. Database Setup
Create a MySQL database named `osahaneat`:
```sql
CREATE DATABASE osahaneat CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. Environment Variables
The application reads sensitive credentials from environment variables. Ensure the following variables are defined in your environment or IDE configuration before launching:

| Environment Variable | Description |
| :--- | :--- |
| `PRIVATE_KEY` | Private key string used for signing and verifying JWT tokens |
| `ACCESS_KEY` | AWS IAM Access Key for S3 bucket uploads |
| `SECRET_KEY` | AWS IAM Secret Key for S3 bucket uploads |

### 3. Application Properties (`src/main/resources/application.yml`)
Adjust connection details and configurations as needed:
* **Database Connection**: Set correct password and username under `spring.datasource` if they differ from the defaults (username: `root`, password: `1234`).
* **Upload Paths**: Set local temporary storage location under `fileUpload.rootPath`.

---

## 🏃 Running the Application

To run the application locally:
```bash
./mvnw spring-boot:run
```

The server will start at `http://localhost:8080` (or your configured port).

---

## 🧪 Testing & Code Quality

### Run Unit and Integration Tests
```bash
./mvnw test
```

### Format Code with Spotless
To ensure code formatting matches the standards before committing:
```bash
./mvnw spotless:apply
```

---

## 🛣️ API Endpoints Summary

### 🔑 Authentication (`/auth`)
* `POST /auth/signup` - Register a new user
* `POST /auth/signing` - Authenticate user credentials and return JWT token
* `POST /auth/introspect` - Validate/Introspect an active token
* `POST /auth/refresh` - Refresh an expired token
* `POST /auth/logout` - Invalidate the active session token

### 👤 Users (`/users`)
* `GET /users` - Retrieve all users (Requires Authorization)
* `GET /users/{userId}` - Get user profile details
* `GET /users/myInfo` - Get current logged-in user profile details
* `PUT /users/{userId}` - Update user profile information

### 🏢 Restaurants (`/restaurant`)
* `POST /restaurant` - Register a new restaurant (multipart/form-data upload)
* `GET /restaurant` - Retrieve home catalog of restaurants
* `GET /restaurant/{id}` - Get details of a specific restaurant
* `PUT /restaurant/{id}` - Update restaurant details
* `DELETE /restaurant/{id}` - Remove a restaurant
* `GET /restaurant/search` - Search restaurants by keyword query
* `GET /restaurant/file/{filename}` - Retrieve restaurant image asset

### 📂 Categories & Menus (`/category` & `/menu`)
* `POST /category` - Create a new food category
* `GET /category` - Retrieve home list of categories
* `PUT /category/{categoryId}` - Update a category
* `DELETE /category/{categoryId}` - Delete a category
* `POST /menu` - Create a new menu item under a category
* `GET /menu/file/{filename}` - Retrieve menu item image asset

### 🛒 Orders (`/order`)
* `POST /order` - Place a new order
