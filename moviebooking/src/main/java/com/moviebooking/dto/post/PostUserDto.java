package com.moviebooking.dto.post;

public record PostUserDto(
        String username,
        String email,
        String password
) {
}
