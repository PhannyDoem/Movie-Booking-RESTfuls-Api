package com.moviebooking.dto.post;

import com.moviebooking.entity.Booking;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PostPaymentDto(
        BigDecimal amount,
        LocalDate paymentDate,
        Booking booking
) {
}
