package com.student.ecommerce.controller;

import com.student.ecommerce.dto.PaymentWebhookRequest;
import com.student.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/webhooks")
public class PaymentWebhookController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<Map<String, String>> handlePaymentWebhook(@RequestBody PaymentWebhookRequest request) {
        paymentService.processWebhook(request.getOrderId(), request.getStatus(), request.getPaymentId());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Webhook processed successfully");
        return ResponseEntity.ok(response);
    }
}
