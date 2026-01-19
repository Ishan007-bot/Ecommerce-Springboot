package com.student.ecommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String userId;
    private Double totalAmount;
    private String status; // CREATED, PAID, FAILED, CANCELLED
    private Instant createdAt;

    private List<OrderItem> items;
}
