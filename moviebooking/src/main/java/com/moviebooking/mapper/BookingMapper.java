package com.moviebooking.mapper;

import com.moviebooking.dto.post.PostBookingDto;
import com.moviebooking.dto.put.PutBookingDto;
import com.moviebooking.entity.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper {
    public Booking postToBookingDto(PostBookingDto postBooingDto) {
        Booking booking = new Booking(
                postBooingDto.seats(),
                postBooingDto.payment(),
                postBooingDto.user(),
                postBooingDto.showtime()
        );
        booking.setBookingId(0L);
        return booking;
    }


    public Booking updateBookingDto(PutBookingDto putBookingDto) {
        Booking booking = new Booking(
                putBookingDto.seats(),
                putBookingDto.payment(),
                putBookingDto.user(),
                putBookingDto.showtime()
        );
        booking.setBookingId(0L);
        return booking;
    }

}
