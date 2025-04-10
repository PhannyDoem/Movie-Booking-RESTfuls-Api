package com.moviebooking.service.implementations;

import com.moviebooking.dto.post.PostPaymentDto;
import com.moviebooking.dto.put.PutPaymentDto;
import com.moviebooking.entity.Payment;
import com.moviebooking.mapper.PaymentMapper;
import com.moviebooking.repository.PaymentRepository;
import com.moviebooking.service.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PaymentServiceImplementation implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;


    @Autowired
    public PaymentServiceImplementation(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }


    @Override
    public Payment createPayment(PostPaymentDto postPaymentDto) {
        Payment payment = paymentMapper.createPaymentDto(postPaymentDto);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findPaymentById(Long paymentId) {
        if (paymentId != null) {
            return paymentRepository.findById(paymentId);
        }
        return Optional.empty();
    }

    @Override
    public Payment updatePayment(Long paymentId, PutPaymentDto putPaymentDto) {
        if (paymentId != null){
            paymentRepository.findById(paymentId).map(
                    updatedPayment -> {
                        updatedPayment.setPaymentDate(putPaymentDto.paymentDate());
                        updatedPayment.setAmount(putPaymentDto.amount());
                        updatedPayment.setBooking(putPaymentDto.booking());
                        Payment payment = paymentRepository.save(updatedPayment);
                        return new ResponseEntity<>(payment, HttpStatus.OK);
                    }
            );
        }
        return paymentRepository.findById(Objects.requireNonNull(paymentId)).orElse(null);
    }
}
