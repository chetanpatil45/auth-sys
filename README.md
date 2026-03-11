# Full Stack Authentication & Role-Based Access Control (RBAC) System

This project is a **full-stack web application** that demonstrates **JWT-based authentication and role-based authorization** using a **Spring Boot backend** and a **React + TypeScript frontend**.

Users can register, log in, and access different content depending on their assigned role (USER or ADMIN).

---

# Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA + Hibernate
* MapStruct
* Lombok
* Maven
* Swagger / OpenAPI

### Frontend

* React
* TypeScript
* Vite
* React Router
* React Query
* Axios
* React Hook Form
* TailwindCSS

---

# Features

### Authentication

* User registration with:

  * Name
  * Email
  * Password
  * Role (USER / ADMIN)

* Secure login using email and password

* JWT token generation after successful login

* Token used for accessing protected APIs

### Authorization (RBAC)

Two roles are implemented:

| Role  | Access                         |
| ----- | ------------------------------ |
| USER  | Can access user-level content  |
| ADMIN | Can access admin-level content |

### API Access Rules

| Endpoint      | Access |
| ------------- | ------ |
| `/api/public` | Public |
| `/api/user`   | USER   |
| `/api/admin`  | ADMIN  |

---

# Frontend Pages

The application includes the following pages:

* **Register Page** – Create a new account
* **Login Page** – Authenticate user
* **Dashboard Page** – Main page after login

Role-based UI components:

* **User Content Card** – visible only to USER role
* **Admin Content Card** – visible only to ADMIN role

---

# Project Structure

```
project-root
│
├── backend
│   ├── src/main/java
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   ├── security
│   └── config
│
├── frontend
│   ├── src
│   ├── pages
│   ├── components
│   ├── services
│   ├── hooks
│   └── routes
```

---

# Backend Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-username/auth-rbac-system.git
cd auth-rbac-system
```

### 2. Navigate to backend

```bash
cd backend
```

### 3. Configure database

Update the database configuration in:

```
application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/auth_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 4. Install dependencies

```bash
mvn clean install
```

---

### 5. Run the backend server

```bash
mvn spring-boot:run
```

Backend will start at:

```
http://localhost:8080
```

Swagger API documentation:

```
http://localhost:8080/swagger-ui.html
```

---

# Frontend Setup Instructions

### 1. Navigate to frontend

```bash
cd frontend
```

---

### 2. Install dependencies

```bash
npm install
```

---

### 3. Start development server

```bash
npm run dev
```

Frontend will run on:

```
http://localhost:5173
```

---

# Authentication Flow

1. User registers with name, email, password, and role.
2. User logs in using email and password.
3. Backend validates credentials.
4. Backend returns a **JWT token**.
5. Frontend stores the token in **localStorage**.
6. Token is attached to API requests using **Axios interceptors**.
7. Backend validates token and role before allowing access.

---

# Bonus Features

* Logout functionality
* Password validation rules
* Loading and error handling states
* Responsive UI with TailwindCSS

---

# Screenshots / Demo

Screenshots and demo video are available in the repository.

---

# Author

**Chetan Bachchhav**

GitHub:
[https://github.com/chetanpatil45](https://github.com/chetanpatil45)

---

If you want, I can also help you create a **much more impressive README (the kind that looks like senior developer repos)** with:

* architecture diagram
* API examples
* JWT flow diagram
* database schema

which **really increases chances in interviews.**
