package com.moviebooking.dto.post;

import com.moviebooking.entity.Movie;
import com.moviebooking.entity.Theater;

import java.time.LocalDate;

public record PostShowtimeDto(
        LocalDate startDate,
        LocalDate endDate,
        Movie movie,
        Theater theater
) {
}
