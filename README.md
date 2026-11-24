# OrderHub – Order Management System

OrderHub is a backend REST API application developed using Java and Spring Boot. It manages products, users, orders, and order items with database integration, validation, exception handling, and Spring Security Basic Authentication.

## Tech Stack

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Spring Security
- BCrypt Password Encoder
- Maven
- Lombok
- Jakarta Bean Validation
- Postman
- Git & GitHub

## Project Features

### 1. Product Management
- Add new products
- Get product by ID
- Get all products
- Update product details
- Delete products
- Product quantity and price management

### 2. User Management
- Register new users
- Get user by ID
- Get all users
- Update user details
- Delete users
- BCrypt password encoding

### 3. Order Management
- Create orders for registered users
- Retrieve order by ID
- Retrieve all orders
- Delete orders
- Automatic order date generation
- Automatic order status assignment

### 4. Order Item Management
- Add multiple products to one order
- Manage product quantity
- Calculate subtotal
- Apply percentage-based discounts
- Calculate final item price
- Calculate total order amount
- Validate available product stock
- Automatically reduce stock after order creation

### 5. Exception Handling
- Custom exceptions
- Global exception handling using `@RestControllerAdvice`
- Product not found handling
- User not found handling
- Order not found handling
- Insufficient stock handling
- Invalid discount handling

### 6. Spring Security – Basic Authentication
- HTTP Basic Authentication
- Database-based username authentication
- Custom `UserDetailsService`
- BCrypt password hashing
- Public user registration endpoint
- Authentication required for other endpoints

## Database Relationships

- One User can have multiple Orders (One-to-Many).
- One Order can have multiple Order Items (One-to-Many).
- One Product can belong to multiple Order Items (One-to-Many).

## Project Architecture

```text
com.orderhub
│
├── model
│   ├── Users
│   ├── Product
│   ├── Order
│   └── OrderItem
│
├── repository
│
├── builder
│
├── dto
│   ├── product
│   ├── user
│   ├── order
│   └── orderitem
│
├── service
│
├── controller
│
├── exception
│
└── config
    └── SecurityConfig
```

## API Endpoints

### Product APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/OrderHub/Products/addProduct` | Add product |
| GET | `/OrderHub/Products/{productId}` | Get product |
| GET | `/OrderHub/Products/all` | Get all products |
| PUT | `/OrderHub/Products/{productId}` | Update product |
| DELETE | `/OrderHub/Products/{productId}` | Delete product |

### User APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/OrderHub/Users/register` | Register user |
| GET | `/OrderHub/Users/{userId}` | Get user |
| GET | `/OrderHub/Users/all` | Get all users |
| PUT | `/OrderHub/Users/{userId}` | Update user |
| DELETE | `/OrderHub/Users/{userId}` | Delete user |

### Order APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/OrderHub/Orders/createOrder` | Create order |
| GET | `/OrderHub/Orders/{orderId}` | Get order by ID |
| GET | `/OrderHub/Orders/all` | Get all orders |
| DELETE | `/OrderHub/Orders/{orderId}` | Delete order |

## Security

- User registration is publicly accessible.
- All other endpoints require HTTP Basic Authentication.
- Passwords are stored using BCrypt hashing.
- Authentication is performed using credentials stored in MySQL.

## Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE orderhub_db;
```

Configure your database username and password in `application.properties`.

## Running the Project

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Configure MySQL database credentials.
4. Run the Spring Boot application.
5. Test APIs using Postman.

Application URL:

```text
http://localhost:8080
```

## Testing

All REST APIs were tested using Postman, including:

- Product CRUD operations
- User registration and management
- Order creation and retrieval
- Order item calculations
- Stock validation
- Exception handling
- Basic Authentication with valid and invalid credentials

## Future Enhancements

- JWT Authentication
- Role-Based Authorization
- Order Update API
- Payment Integration
- API Documentation using Swagger/OpenAPI

## Author

**Mahender Thota**

GitHub: https://github.com/mahender-thota
