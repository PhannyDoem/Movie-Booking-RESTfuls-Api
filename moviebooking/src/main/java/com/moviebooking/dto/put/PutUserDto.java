package com.moviebooking.dto.put;

public record PutUserDto(
        String username,
        String email,
        String password
) {
}
