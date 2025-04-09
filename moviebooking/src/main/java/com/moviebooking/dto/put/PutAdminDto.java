package com.moviebooking.dto.put;

public record PutAdminDto(
        String username,
        String email,
        String password
) {
}
