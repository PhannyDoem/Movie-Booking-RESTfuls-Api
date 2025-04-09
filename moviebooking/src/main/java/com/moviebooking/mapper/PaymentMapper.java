package com.moviebooking.mapper;

import com.moviebooking.dto.post.PostPaymentDto;
import com.moviebooking.dto.put.PutPaymentDto;
import com.moviebooking.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment createPaymentDto(PostPaymentDto postPaymentDto) {
        Payment payment = new Payment(
                postPaymentDto.amount(),
                postPaymentDto.paymentDate(),
                postPaymentDto.booking()
        );
        payment.setPaymentId(0L);
        return payment;
    }

    public Payment updatePaymentDto(PutPaymentDto putPaymentDto) {
        Payment payment = new Payment(
                putPaymentDto.amount(),
                putPaymentDto.paymentDate(),
                putPaymentDto.booking()
        );
        payment.setPaymentId(0L);
        return payment;
    }
}
