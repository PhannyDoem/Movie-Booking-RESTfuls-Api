package com.moviebooking.dto.put;

import com.moviebooking.entity.Movie;
import com.moviebooking.entity.Theater;

import java.time.LocalDate;

public record PutShowtimeDto(
        LocalDate startDate,
        LocalDate endDate,
        Integer seats,
        Movie movie,
        Theater theater
) {
}
