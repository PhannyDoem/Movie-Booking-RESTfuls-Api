package com.moviebooking.controller;

import com.moviebooking.dto.post.PostPaymentDto;
import com.moviebooking.dto.put.PutPaymentDto;
import com.moviebooking.entity.Payment;
import com.moviebooking.service.implementations.PaymentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/values/v1")
public class PaymentController {
    private final PaymentServiceImplementation paymentServiceImplementation;

    @Autowired
    public PaymentController(PaymentServiceImplementation paymentServiceImplementation) {
        this.paymentServiceImplementation = paymentServiceImplementation;
    }

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestBody PostPaymentDto postPaymentDto) {
        Payment payment = paymentServiceImplementation.createPayment(postPaymentDto);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }
    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentServiceImplementation.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/payments/{paymentId}")
    public Payment getPaymentById(@PathVariable Long paymentId) {
        return paymentServiceImplementation.findPaymentById(paymentId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("payments/{paymentId}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long paymentId,@RequestBody PutPaymentDto putPaymentDto) {
        Payment payment = paymentServiceImplementation.updatePayment(paymentId, putPaymentDto);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
