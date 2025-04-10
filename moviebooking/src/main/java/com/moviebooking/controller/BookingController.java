package com.moviebooking.controller;

import com.moviebooking.dto.post.PostBookingDto;
import com.moviebooking.dto.put.PutBookingDto;
import com.moviebooking.entity.Booking;
import com.moviebooking.service.implementations.BookingServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/values/v1")
public class BookingController {
    private final BookingServiceImplementation bookingServiceImplementation;


    @Autowired
    public BookingController(BookingServiceImplementation bookingServiceImplementation) {
        this.bookingServiceImplementation = bookingServiceImplementation;
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody PostBookingDto postBooingDto) {
        Booking booking = bookingServiceImplementation.createBooking(postBooingDto);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingServiceImplementation.getAllBookings(), HttpStatus.OK);
    }
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<Optional<Booking>> getBookingById(@PathVariable Long bookingId) {
        return new ResponseEntity<>(bookingServiceImplementation.getBookingById(bookingId), HttpStatus.OK);
    }
    @PutMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId,@RequestBody PutBookingDto putBookingDto) {
        Booking updatedBooking = bookingServiceImplementation.updateBooking(bookingId, putBookingDto);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

}
