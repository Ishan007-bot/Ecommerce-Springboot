package com.student.ecommerce.controller;

import com.student.ecommerce.dto.PaymentRequest;
import com.student.ecommerce.model.Payment;
import com.student.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentRequest request) {
        Payment payment = paymentService.createPayment(request.getOrderId(), request.getAmount());
        return ResponseEntity.ok(payment);
    }
}
