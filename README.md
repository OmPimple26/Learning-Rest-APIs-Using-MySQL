# 📘 Student API – Spring Boot + MySQL + Swagger 3

A simple REST API built using Spring Boot, Spring Data JPA, MySQL, and Swagger UI for managing student records.
This project demonstrates CRUD operations, filtering, and API documentation using SpringDoc (OpenAPI 3).

---

## 🚀 Features

> Create student

> Fetch all students

> Fetch student by ID

> Update student

> Delete student

> Filter by department and year

> Fully documented APIs using Swagger 3

---

## 🛠 Technologies Used

> Java 17

> Spring Boot 3.5

> Spring Data JPA

> MySQL

> Lombok

> Swagger UI (Springdoc-openapi)

> Maven

---

## 📦 Project Setup

1️⃣ Clone the project
```
git clone https://github.com/your-username/studentapi.git
cd studentapi
```

2️⃣ Configure MySQL in application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

3️⃣ Run the application
```
mvn spring-boot:run
```

---

## 📘 Swagger Documentation

After running the application, open:

👉 Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```


👉 OpenAPI JSON:

```
http://localhost:8080/v3/api-docs
```

---

## 📑 API Examples

### ➕ Create Student (POST)
```
POST /api/students
Content-Type: application/json
```

Request Body
```
{
  "name": "Om Pimple",
  "department": "Computer",
  "year": "Third Year",
  "email": "om@example.com",
  "mobile": "9876543210"
}
```

Response
```
{
  "id": 1,
  "name": "Om Pimple",
  "department": "Computer",
  "year": "Third Year",
  "email": "om@example.com",
  "mobile": "9876543210"
}
```

### 📥 Get All Students (GET)
```
GET /api/students
```

### 🔍 Get Student by ID (GET)
```
GET /api/students/{id}
```

### ✏️ Update Student (PUT)
```
PUT /api/students/{id}
```

Request Body
```
{
  "name": "Om Updated",
  "department": "IT",
  "year": "Final Year",
  "email": "updated@example.com",
  "mobile": "9999999999"
}
```

### ❌ Delete Student (DELETE)
```
DELETE /api/students/{id}
```

### 🔎 Filter Students (GET)
```
GET /api/students/filter?department=Computer&year=Third Year
```

---

## 📂 Project Structure

```
.mvn/
    └── wrapper/
        └── maven-wrapper.properties
src/
    ├── main/
        ├── java/
            └── com/
                └── example/
                    └── studentapi/
                        ├── config/
                            └── SwaggerConfig.java
                        ├── controller/
                            └── StudentController.java
                        ├── dto/
                            └── StudentDto.java
                        ├── entity/
                            └── Student.java
                        ├── repository/
                            └── StudentRepository.java
                        ├── service/
                            ├── StudentService.java
                            └── StudentServiceImpl.java
                        └── StudentapiApplication.java
        └── resources/
            └── application.properties
    └── test/
        └── java/
            └── com/
                └── example/
                    └── studentapi/
                        └── StudentapiApplicationTests.java
.gitattributes
.gitignore
mvnw
mvnw.cmd
pom.xml
```

---

## 🤝 Contribution

Feel free to open issues or submit pull requests.

---

## 📜 License

This project is licensed under the MIT License.
