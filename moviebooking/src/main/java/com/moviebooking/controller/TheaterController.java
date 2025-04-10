package com.moviebooking.controller;

import com.moviebooking.dto.post.PostTheaterDto;
import com.moviebooking.dto.put.PutTheaterDto;
import com.moviebooking.entity.Theater;
import com.moviebooking.service.implementations.TheaterServiceImplementation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/values/v1")
public class TheaterController {
    private final TheaterServiceImplementation theaterServiceImplementation;

    @Autowired
    public TheaterController(TheaterServiceImplementation theaterServiceImplementation) {
        this.theaterServiceImplementation = theaterServiceImplementation;
    }

    @PostMapping("/theaters")
    public ResponseEntity<Theater> createTheater(@RequestBody PostTheaterDto postTheaterDto) {
        Theater theater = theaterServiceImplementation.createTheater(postTheaterDto);
        return new ResponseEntity<>(theater, HttpStatus.CREATED);
    }

    @PutMapping("theaters/{theaterId}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long theaterId,@RequestBody PutTheaterDto putTheaterDto) {
        Theater theater = theaterServiceImplementation.updateTheater(theaterId, putTheaterDto);
        return new ResponseEntity<>(theater, HttpStatus.OK);
    }
    @GetMapping("/theaters")
    public ResponseEntity<List<Theater>> getAllTheaters() {
        List<Theater> theaters = theaterServiceImplementation.getAllTheaters();
        return new ResponseEntity<>(theaters, HttpStatus.OK);
    }
    @GetMapping("/theaters/{theaterId}")
    public ResponseEntity<Optional<Theater>> getTheaterById(@PathVariable Long theaterId) {
        Optional<Theater> theater = theaterServiceImplementation.getTheaterById(theaterId);
        return new ResponseEntity<>(theater, HttpStatus.OK);
    }
}
