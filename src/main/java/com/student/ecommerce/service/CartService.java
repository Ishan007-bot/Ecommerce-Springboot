package com.student.ecommerce.service;

import com.student.ecommerce.dto.CartItemResponse;
import com.student.ecommerce.model.CartItem;
import com.student.ecommerce.model.Product;
import com.student.ecommerce.repository.CartRepository;
import com.student.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public CartItem addToCart(String userId, String productId, Integer quantity) {
        // Check if product exists
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        // Check if item already in cart
        Optional<CartItem> existingItem = cartRepository.findByUserIdAndProductId(userId, productId);

        if (existingItem.isPresent()) {
            // Update quantity
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            return cartRepository.save(item);
        } else {
            // Add new item
            CartItem newItem = new CartItem();
            newItem.setUserId(userId);
            newItem.setProductId(productId);
            newItem.setQuantity(quantity);
            return cartRepository.save(newItem);
        }
    }

    public List<CartItemResponse> getCartItems(String userId) {
        List<CartItem> cartItems = cartRepository.findByUserId(userId);

        return cartItems.stream().map(item -> {
            CartItemResponse response = new CartItemResponse();
            response.setId(item.getId());
            response.setProductId(item.getProductId());
            response.setQuantity(item.getQuantity());

            // Get product details
            Product product = productRepository.findById(item.getProductId()).orElse(null);
            response.setProduct(product);

            return response;
        }).collect(Collectors.toList());
    }

    @Transactional
    public void clearCart(String userId) {
        cartRepository.deleteByUserId(userId);
    }
}
