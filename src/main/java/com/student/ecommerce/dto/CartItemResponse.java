package com.student.ecommerce.dto;

import com.student.ecommerce.model.Product;
import lombok.Data;

@Data
public class CartItemResponse {

    private String id;
    private String productId;
    private Integer quantity;
    private Product product;
}
