package com.moviebooking.service.interfaces;

import com.moviebooking.dto.post.PostShowtimeDto;
import com.moviebooking.dto.put.PutShowtimeDto;
import com.moviebooking.entity.Showtime;

import java.util.List;
import java.util.Optional;

public interface ShowtimeService {
    Showtime createShowtime(PostShowtimeDto postShowtimeDto);
    List<Showtime> getAllShowtimes();
    Optional<Showtime> getShowtimeById(Long showtimeId);
    Showtime updateShowtime(PutShowtimeDto putShowtimeDto);
}
