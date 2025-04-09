package com.moviebooking.service.implementations;

import com.moviebooking.dto.post.PostMovieDto;
import com.moviebooking.dto.put.PutMovieDto;
import com.moviebooking.entity.Movie;
import com.moviebooking.mapper.MovieMapper;
import com.moviebooking.repository.MovieRepository;
import com.moviebooking.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieServiceImplementation implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;


    @Autowired
    public MovieServiceImplementation(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }


    @Override
    public Movie postMovieDto(PostMovieDto postMovieDto) {
        Movie movie = movieMapper.postToMovieDto(postMovieDto);
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAllMovies();
    }

    @Override
    public Optional<Movie> getMovieById(Long movieId) {
        if (movieRepository.existsById(movieId)) {
            return movieRepository.findById(movieId);
        }
        return Optional.empty();
    }

    @Override
    public Movie updateMovieById(Long movieId, PutMovieDto putMovieDto) {
        if (movieId != null){
            movieRepository.findById(movieId).map(movie -> {
                movie.setTitle(putMovieDto.title());
                movie.setGenre(putMovieDto.genre());
                movie.setReleaseDate(putMovieDto.releaseDate());
                movie.setDirector(putMovieDto.director());
                movie.setDuration(putMovieDto.duration());
                movie.setCast(putMovieDto.cast());
                Movie updatedMovie = movieRepository.save(movie);
                return movieRepository.save(updatedMovie);
            }
            ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        return movieRepository.findById(Objects.requireNonNull(movieId)).orElse(null);
    }

}
