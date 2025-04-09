package com.moviebooking.dto.put;

import com.moviebooking.entity.Booking;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PutPaymentDto(
        BigDecimal amount,
        LocalDate paymentDate,
        Booking booking
) {
}
