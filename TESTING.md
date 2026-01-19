# Product API Testing Guide

## Base URL
```
http://localhost:8080
```

## 1. Create Product
**Method:** POST  
**URL:** `http://localhost:8080/api/products`  
**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000.0,
  "stock": 10
}
```

**Expected Response:**
```json
{
  "id": "generated-id",
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000.0,
  "stock": 10
}
```

---

## 2. Get All Products
**Method:** GET  
**URL:** `http://localhost:8080/api/products`

**Expected Response:**
```json
[
  {
    "id": "generated-id",
    "name": "Laptop",
    "description": "Gaming Laptop",
    "price": 50000.0,
    "stock": 10
  }
]
```

---

## Sample Products to Create

### Product 1: Laptop
```json
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000.0,
  "stock": 10
}
```

### Product 2: Mouse
```json
{
  "name": "Mouse",
  "description": "Wireless Mouse",
  "price": 1000.0,
  "stock": 50
}
```

### Product 3: Keyboard
```json
{
  "name": "Keyboard",
  "description": "Mechanical Keyboard",
  "price": 3000.0,
  "stock": 30
}
```
