package com.student.ecommerce.dto;

import lombok.Data;

@Data
public class PaymentWebhookRequest {

    private String orderId;
    private String status; // SUCCESS or FAILED
    private String paymentId;
}
