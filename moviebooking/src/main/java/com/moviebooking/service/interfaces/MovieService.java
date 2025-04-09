package com.moviebooking.service.interfaces;

import com.moviebooking.dto.post.PostMovieDto;
import com.moviebooking.dto.put.PutMovieDto;
import com.moviebooking.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie postMovieDto(PostMovieDto postMovieDto);
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(Long movieId);
    Movie updateMovieById(Long movieId, PutMovieDto putMovieDto);
}
