package com.student.ecommerce.service;

import com.student.ecommerce.model.Order;
import com.student.ecommerce.model.Payment;
import com.student.ecommerce.repository.OrderRepository;
import com.student.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Payment createPayment(String orderId, Double amount) {
        // Verify order exists
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Check if order status is CREATED
        if (!"CREATED".equals(order.getStatus())) {
            throw new RuntimeException("Order is not in CREATED status");
        }

        // Create payment
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setStatus("PENDING");
        payment.setPaymentId("pay_" + UUID.randomUUID().toString().substring(0, 8));
        payment.setCreatedAt(Instant.now());

        return paymentRepository.save(payment);
    }

    public void processWebhook(String orderId, String status, String paymentId) {
        // Find payment
        Payment payment = paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Payment not found for order: " + orderId));

        // Update payment status
        payment.setStatus(status);
        if (paymentId != null) {
            payment.setPaymentId(paymentId);
        }
        paymentRepository.save(payment);

        // Update order status
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if ("SUCCESS".equals(status)) {
            order.setStatus("PAID");
        } else if ("FAILED".equals(status)) {
            order.setStatus("FAILED");
        }

        orderRepository.save(order);
    }
}
