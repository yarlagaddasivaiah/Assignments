
package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.entity.Payment;
import com.ecommerce.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(
            @RequestParam Long orderId,
            @RequestBody Double amount) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(orderId, amount));
    }
}
