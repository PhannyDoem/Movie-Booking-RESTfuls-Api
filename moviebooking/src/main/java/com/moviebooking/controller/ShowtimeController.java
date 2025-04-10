package com.moviebooking.controller;

import com.moviebooking.dto.post.PostShowtimeDto;
import com.moviebooking.dto.put.PutShowtimeDto;
import com.moviebooking.entity.Showtime;
import com.moviebooking.service.implementations.ShowtimeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/values/v1")
public class ShowtimeController {
    private final ShowtimeServiceImplementation showtimeServiceImplementation;

    @Autowired
    public ShowtimeController(ShowtimeServiceImplementation showtimeServiceImplementation) {
        this.showtimeServiceImplementation = showtimeServiceImplementation;
    }


    @PostMapping("/showtimes")
    public ResponseEntity<Showtime> createShowtime(@RequestBody PostShowtimeDto postShowtimeDto){
        Showtime showtime = showtimeServiceImplementation.createShowtime(postShowtimeDto);
        return new ResponseEntity<>(showtime, HttpStatus.CREATED);
    }
    @GetMapping("/showtimes")
    public ResponseEntity<List<Showtime>> getAllShowtimes(){
        List<Showtime> showtimes = showtimeServiceImplementation.getAllShowtimes();
        return new ResponseEntity<>(showtimes, HttpStatus.OK);
    }

    @GetMapping("showtimes/{showtimeId}")
    public ResponseEntity<Optional<Showtime>> getShowtimeById(@PathVariable Long showtimeId){
        Optional<Showtime> showtime = showtimeServiceImplementation.getShowtimeById(showtimeId);
        return new ResponseEntity<>(showtime, HttpStatus.OK);
    }
    @PutMapping("/showtimes/{showtimeId}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable Long showtimeId,@RequestBody PutShowtimeDto putShowtimeDto){
        Showtime update = showtimeServiceImplementation.updateShowtime(showtimeId,putShowtimeDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}
