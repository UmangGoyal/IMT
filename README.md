# 🧾 Inventory Management System (Spring Boot + JWT + MySQL)

A secure backend system built with **Spring Boot**, **JWT-based Authentication**, and **MySQL** that supports role-based access for managing products and users. 
It is designed for learning, assignments, and as a portfolio-ready project.

## 📚 Features

- ✅ User Registration & Login (JWT auth)
- ✅ Role-Based Access Control (`USER`, `ADMIN`)
- ✅ Secure CRUD for Products
- ✅ Admin-only: View all users & most-added product
- ✅ MySQL for persistent storage
- ✅ Unit Testing with JUnit

## 🗂️ Project Structure
<pre> <code> Inventory/ 
    ├── Controller/
    ├── DTO/ 
    ├── Model/ 
    ├── Repository/ 
    ├── Security/ 
    ├── Service/ 
    ├── config/ 
    └── Application.java </code> </pre>


## 🛠️ Technologies Used

- Java 17
- Spring Boot 3+
- Spring Security (JWT + Role Based Auth)
- MySQL
- Maven
- JPA + Hibernate
- JUnit 5


## 🧑‍💻 Roles & Permissions

| Role   | Endpoint Access |
|--------|------------------|
| USER   | Register, Login, Manage own products |
| ADMIN  | All of USER + View all users, Most added product |

## 💽 Database Schema

### `users` table
```
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
);
```
### `products` table
```
CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    type VARCHAR(255),
    sku VARCHAR(100),
    image_url TEXT,
    description TEXT,
    quantity INT,
    price DECIMAL(10,2)
);
```

## ▶️ How to Run Locally

1. **Clone the repo**
   git clone https://github.com/your-username/inventory-management.git
   cd inventory-management
2. **Setup MySQL DB**
   Start MySQL Server
   Create a DB: CREATE DATABASE inventory;
   **Configure application.properties:**
   spring.datasource.url=jdbc:mysql://localhost:3306/inventory
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
3. **Run the App**
   ./mvnw spring-boot:run
   App starts at: http://localhost:8080

## 📬 **Using Postman (Step-by-Step)**

**🔐 1. Register (no auth)**
POST /auth/register
```
Body (JSON):
{
  "username": "umang",
  "password": "123",
  "role": "USER"
}
```

**🔑 2. Login**
POST /auth/login

```
Body:
{
  "username": "umang",
  "password": "123"
}
✅ Get JWT token in response.
```


**3. Add Product (USER)**
```
POST /user/products
Headers: Authorization: Bearer <JWT>
Body:
{
  "name": "iPhone",
  "type": "Electronics",
  "sku": "APL-101",
  "imageUrl": "http://img.com/img.png",
  "description": "Apple iPhone",
  "quantity": 5,
  "price": 999.99
}
```
## 📬 How to Test Using Postman

1. **Register:** `POST /auth/register`
2. **Login:** `POST /auth/login` → Copy the token
3. **Add Authorization Header:**
   - Key: `Authorization`
   - Value: `Bearer <your_token_here>`
4. Use `GET`, `PUT`, `DELETE` on `/user/products/**`
5. Use admin token for:
   - `GET /admin_only/users`
   - `GET /admin_only/most-added-product`

## **🧪 Unit Testing**
Test example: ProductServiceTest.java
```
@Test
public void testGetAllProductsReturnsList() {
    List<Product> products = productService.getAllProducts();
    assertNotNull(products);
}

Run via IntelliJ or ./mvnw test
```

## **🚀 Future Scope**
 - Assign products to specific users (ownership)
 - Add categories for products
 - Dockerize the app
 - Frontend using React or Vue
 - File upload for image URLs
 - Email verification on registration

**🙌 Author**
Developed by Umang Goyal — feel free to connect on [https://www.linkedin.com/in/umang-goyal-8016621b3].
