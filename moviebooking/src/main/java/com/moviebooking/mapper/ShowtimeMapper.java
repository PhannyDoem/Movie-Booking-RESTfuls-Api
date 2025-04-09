package com.moviebooking.mapper;

import com.moviebooking.dto.post.PostShowtimeDto;
import com.moviebooking.dto.put.PutShowtimeDto;
import com.moviebooking.entity.Showtime;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeMapper {
    public Showtime postToShowtimeDto(PostShowtimeDto postShowtimeDto){
        Showtime showtime = new Showtime(
                postShowtimeDto.startDate(),
                postShowtimeDto.endDate(),
                postShowtimeDto.seats(),
                postShowtimeDto.movie(),
                postShowtimeDto.theater()
        );
        showtime.setShowtimeId(0L);
        return showtime;
    }


    public Showtime updateShowtimeDto(PutShowtimeDto putShowtimeDto){
        Showtime showtime = new Showtime(
                putShowtimeDto.startDate(),
                putShowtimeDto.endDate(),
                putShowtimeDto.seats(),
                putShowtimeDto.movie(),
                putShowtimeDto.theater()
        );
        showtime.setShowtimeId(0L);
        return showtime;
    }
}
