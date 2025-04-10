package com.moviebooking.service.interfaces;

import com.moviebooking.dto.post.PostPaymentDto;
import com.moviebooking.dto.put.PutPaymentDto;
import com.moviebooking.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment createPayment(PostPaymentDto postPaymentDto);
    List<Payment> getAllPayments();
    Optional<Payment> findPaymentById(Long paymentId);
    Payment updatePayment(Long paymentId, PutPaymentDto putPaymentDto);
}
