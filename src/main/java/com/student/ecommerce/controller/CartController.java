package com.student.ecommerce.controller;

import com.student.ecommerce.dto.AddToCartRequest;
import com.student.ecommerce.dto.CartItemResponse;
import com.student.ecommerce.model.CartItem;
import com.student.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<CartItem> addToCart(@RequestBody AddToCartRequest request) {
        CartItem cartItem = cartService.addToCart(
                request.getUserId(),
                request.getProductId(),
                request.getQuantity());
        return ResponseEntity.ok(cartItem);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItemResponse>> getCart(@PathVariable String userId) {
        List<CartItemResponse> cartItems = cartService.getCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<Map<String, String>> clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Cart cleared successfully");
        return ResponseEntity.ok(response);
    }
}
