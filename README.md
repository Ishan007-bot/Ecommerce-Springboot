# E-Commerce Backend API

A minimal e-commerce backend system built with Spring Boot and MongoDB.

## Features
- Product Management (Create, List)
- Shopping Cart (Add, View, Clear)
- Order Management (Create, View)
- Payment Integration (Mock Service)
- Payment Webhooks

## Tech Stack
- Java 17
- Spring Boot 4.0.1
- MongoDB
- Maven

## Prerequisites
- Java 17 or higher
- MongoDB installed and running on localhost:27017
- Maven

## Setup Instructions

1. **Install MongoDB**
   - Download from https://www.mongodb.com/try/download/community
   - Start MongoDB service

2. **Navigate to project directory**
   ```bash
   cd ecommerce-backend
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Application will start on**
   ```
   http://localhost:8080
   ```

## API Endpoints

### Product APIs
- `POST /api/products` - Create a product
- `GET /api/products` - Get all products

### Cart APIs
- `POST /api/cart/add` - Add item to cart
- `GET /api/cart/{userId}` - Get user's cart
- `DELETE /api/cart/{userId}/clear` - Clear cart

### Order APIs
- `POST /api/orders` - Create order from cart
- `GET /api/orders/{orderId}` - Get order details

### Payment APIs
- `POST /api/payments/create` - Create payment
- `POST /api/webhooks/payment` - Payment webhook (called by payment service)

## Testing
Use Postman to test all endpoints.

## Project Structure
```
src/main/java/com/student/ecommerce/
├── controller/       # REST controllers
├── service/          # Business logic
├── repository/       # Database repositories
├── model/            # Entity models
├── dto/              # Data transfer objects
├── webhook/          # Webhook controllers
├── config/           # Configuration classes
└── EcommerceBackendApplication.java
```

## Author
Student Assignment - E-Commerce Backend API
