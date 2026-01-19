package com.student.ecommerce.model;

import lombok.Data;

@Data
public class OrderItem {

    private String productId;
    private String productName;
    private Integer quantity;
    private Double price;
}
