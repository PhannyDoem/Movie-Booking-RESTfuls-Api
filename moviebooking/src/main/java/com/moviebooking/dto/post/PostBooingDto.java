package com.moviebooking.dto.post;

import com.moviebooking.entity.Payment;
import com.moviebooking.entity.User;

public record PostBooingDto(
        Integer seats,
        Payment payment,
        User user
) {
}
