package com.moviebooking.service.interfaces;

import com.moviebooking.dto.post.PostBooingDto;
import com.moviebooking.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking createBooking(PostBooingDto postBooingDto);
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long bookingId);
    Booking updateBooking(Long bookingId, PostBooingDto postBooingDto);
}
