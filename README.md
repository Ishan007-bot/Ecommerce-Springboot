# E-Commerce Backend API 🛒

A complete e-commerce backend system built with Spring Boot and MongoDB Atlas, featuring product management, shopping cart, order processing, and payment integration with webhooks.

## 🎯 Features

✅ **Product Management** - Create and list products  
✅ **Shopping Cart** - Add items, view cart, clear cart  
✅ **Order Management** - Create orders from cart with stock validation  
✅ **Payment Integration** - Mock payment service with webhook callbacks  
✅ **Order Status Updates** - Automatic status updates via payment webhooks  
✅ **Stock Management** - Automatic inventory updates  

## 🛠️ Tech Stack

- **Java** 17
- **Spring Boot** 4.0.1
- **MongoDB Atlas** (Cloud Database)
- **Maven** (Build Tool)
- **Lombok** (Code Generation)

## 📋 Prerequisites

- Java 17 or higher
- Maven
- MongoDB Atlas account (or local MongoDB)

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/Ishan007-bot/Ecommerce-Springboot.git
cd ecommerce-backend
```

### 2. Configure MongoDB Atlas

Update `src/main/resources/application.yaml` with your MongoDB Atlas URI:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb+srv://username:password@cluster.mongodb.net/ecommerce_db
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

The application will start on **http://localhost:8080**

## 🔌 API Endpoints

### Product APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/products` | Create a new product |
| GET | `/api/products` | Get all products |

### Cart APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/cart/add` | Add item to cart |
| GET | `/api/cart/{userId}` | Get user's cart |
| DELETE | `/api/cart/{userId}/clear` | Clear user's cart |

### Order APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/orders` | Create order from cart |
| GET | `/api/orders/{orderId}` | Get order details |

### Payment APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/payments/create` | Create payment for order |
| POST | `/api/webhooks/payment` | Payment webhook callback |

## 🧪 Testing with Postman

### Complete Flow Example

**1. Create a Product**
```http
POST http://localhost:8080/api/products
Content-Type: application/json

{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000.0,
  "stock": 10
}
```

**2. Add to Cart**
```http
POST http://localhost:8080/api/cart/add
Content-Type: application/json

{
  "userId": "user123",
  "productId": "<product_id_from_step_1>",
  "quantity": 2
}
```

**3. Create Order**
```http
POST http://localhost:8080/api/orders
Content-Type: application/json

{
  "userId": "user123"
}
```

**4. Create Payment**
```http
POST http://localhost:8080/api/payments/create
Content-Type: application/json

{
  "orderId": "<order_id_from_step_3>",
  "amount": 100000.0
}
```

**5. Simulate Payment Success (Webhook)**
```http
POST http://localhost:8080/api/webhooks/payment
Content-Type: application/json

{
  "orderId": "<order_id>",
  "status": "SUCCESS",
  "paymentId": "pay_12345"
}
```

**6. Check Order Status**
```http
GET http://localhost:8080/api/orders/<order_id>
```

See `API_DOCUMENTATION.md` for detailed API documentation.

## 📁 Project Structure

```
src/main/java/com/student/ecommerce/
├── controller/          # REST API Controllers
│   ├── ProductController.java
│   ├── CartController.java
│   ├── OrderController.java
│   ├── PaymentController.java
│   └── PaymentWebhookController.java
├── service/             # Business Logic Layer
│   ├── ProductService.java
│   ├── CartService.java
│   ├── OrderService.java
│   └── PaymentService.java
├── repository/          # Database Repositories
│   ├── ProductRepository.java
│   ├── CartRepository.java
│   ├── OrderRepository.java
│   ├── PaymentRepository.java
│   └── UserRepository.java
├── model/               # Entity Models
│   ├── User.java
│   ├── Product.java
│   ├── CartItem.java
│   ├── Order.java
│   ├── OrderItem.java
│   └── Payment.java
├── dto/                 # Data Transfer Objects
│   ├── AddToCartRequest.java
│   ├── CartItemResponse.java
│   ├── CreateOrderRequest.java
│   ├── PaymentRequest.java
│   └── PaymentWebhookRequest.java
├── config/              # Configuration Classes
│   └── RestTemplateConfig.java
└── EcommerceBackendApplication.java
```

## 🗄️ Database Schema

### Collections
- `users` - User information
- `products` - Product catalog
- `cart_items` - Shopping cart items
- `orders` - Order records
- `payments` - Payment transactions

### Order Status Flow
1. **CREATED** - Order created from cart
2. **PAID** - Payment successful
3. **FAILED** - Payment failed

## 🔧 Configuration

The application uses MongoDB Atlas. Configuration is in `application.yaml`:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb+srv://...
server:
  port: 8080
```

## 📝 Notes

- Cart is automatically cleared after order creation
- Product stock is reduced when order is created
- Payment status starts as `PENDING` and updates via webhook
- Order status updates automatically when payment webhook is received

## 👨‍💻 Author

**Ishan Ganguly**  
**Student ID:** 24BCS10330

## 📄 License

This project is created for educational purposes.
