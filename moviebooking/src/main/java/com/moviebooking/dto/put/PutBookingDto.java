package com.moviebooking.dto.put;

import com.moviebooking.entity.Payment;
import com.moviebooking.entity.User;

public record PutBookingDto(
        Integer seats,
        Payment payment,
        User user
) {
}
