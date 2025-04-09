package com.moviebooking.controller;

import com.moviebooking.dto.post.PostMovieDto;
import com.moviebooking.dto.put.PutMovieDto;
import com.moviebooking.entity.Movie;
import com.moviebooking.service.implementations.MovieServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/values/v1")
public class MovieController {
    private final MovieServiceImplementation movieServiceImplementation;

    @Autowired
    public MovieController(MovieServiceImplementation movieServiceImplementation) {
        this.movieServiceImplementation = movieServiceImplementation;
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> postMovieDto(@RequestBody PostMovieDto postMovieDto) {
        Movie movie = movieServiceImplementation.postMovieDto(postMovieDto);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId) {
        Movie movie = movieServiceImplementation.getMovieById(movieId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(movie, HttpStatus.OK);

    }
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieServiceImplementation.getAllMovies(), HttpStatus.OK);
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable Long movieId,@RequestBody PutMovieDto putMovieDto) {
        Movie updateMovie = movieServiceImplementation.updateMovieById(movieId, putMovieDto);
        return new ResponseEntity<>(updateMovie, HttpStatus.OK);
    }
}
