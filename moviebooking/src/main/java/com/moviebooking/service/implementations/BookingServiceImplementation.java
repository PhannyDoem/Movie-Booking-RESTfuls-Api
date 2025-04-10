package com.moviebooking.service.implementations;

import com.moviebooking.dto.post.PostBookingDto;
import com.moviebooking.dto.put.PutBookingDto;
import com.moviebooking.entity.Booking;
import com.moviebooking.mapper.BookingMapper;
import com.moviebooking.repository.BookingRepository;
import com.moviebooking.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookingServiceImplementation implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingServiceImplementation(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public Booking createBooking(PostBookingDto postBooingDto) {
        Booking booking = bookingMapper.postToBookingDto(postBooingDto);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long bookingId) {
        if (bookingRepository.existsById(bookingId)) {
            return bookingRepository.findById(bookingId);
        }
        return Optional.empty();
    }

    @Override
    public Booking updateBooking(Long bookingId, PutBookingDto putBookingDto) {
        if (bookingId != null) {
            bookingRepository.findById(bookingId).map(
                    updatedBooking -> {
                        updatedBooking.setSeats(putBookingDto.seats());
                        updatedBooking.setPayment(putBookingDto.payment());
                        updatedBooking.setShowtime(putBookingDto.showtime());
                        Booking booking = bookingRepository.save(updatedBooking);
                        return new ResponseEntity<>(booking, HttpStatus.OK);
                    }
            );
        }
        return bookingRepository.findById(Objects.requireNonNull(bookingId)).orElse(null);
    }
}
