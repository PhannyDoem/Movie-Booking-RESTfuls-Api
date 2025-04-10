package com.moviebooking.service.interfaces;

import com.moviebooking.dto.post.PostBookingDto;
import com.moviebooking.dto.put.PutBookingDto;
import com.moviebooking.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking createBooking(PostBookingDto postBooingDto);
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long bookingId);
    Booking updateBooking(Long bookingId, PutBookingDto putBookingDto);
}
