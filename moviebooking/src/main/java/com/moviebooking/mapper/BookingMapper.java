package com.moviebooking.mapper;

import com.moviebooking.dto.post.PostBooingDto;
import com.moviebooking.dto.put.PutBookingDto;
import com.moviebooking.entity.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper {
    public Booking postToBookingDto(PostBooingDto postBooingDto) {
        Booking booking = new Booking(
                postBooingDto.seats(),
                postBooingDto.payment(),
                postBooingDto.user()
        );
        booking.setBookingId(0L);
        return booking;
    }


    public Booking updateBookingDto(PutBookingDto putBookingDto) {
        Booking booking = new Booking(
                putBookingDto.seats(),
                putBookingDto.payment(),
                putBookingDto.user()
        );
        booking.setBookingId(0L);
        return booking;
    }

}
