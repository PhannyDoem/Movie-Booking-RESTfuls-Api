package com.moviebooking.service.implementations;

import com.moviebooking.dto.post.PostShowtimeDto;
import com.moviebooking.dto.put.PutShowtimeDto;
import com.moviebooking.entity.Showtime;
import com.moviebooking.mapper.ShowtimeMapper;
import com.moviebooking.repository.ShowtimeRepository;
import com.moviebooking.service.interfaces.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShowtimeServiceImplementation implements ShowtimeService {
    private final ShowtimeRepository showtimeRepository;
    private final ShowtimeMapper showtimeMapper;

    @Autowired
    public ShowtimeServiceImplementation(ShowtimeRepository showtimeRepository, ShowtimeMapper showtimeMapper) {
        this.showtimeRepository = showtimeRepository;
        this.showtimeMapper = showtimeMapper;
    }


    @Override
    public Showtime createShowtime(PostShowtimeDto postShowtimeDto) {
        Showtime showtime = showtimeMapper.postToShowtimeDto(postShowtimeDto);
        return showtimeRepository.save(showtime);
    }

    @Override
    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    @Override
    public Optional<Showtime> getShowtimeById(Long showtimeId) {
        if (showtimeId != null){
            return showtimeRepository.findById(showtimeId);
        }
        return Optional.empty();
    }

    @Override
    public Showtime updateShowtime(Long showtimeId, PutShowtimeDto putShowtimeDto) {
        if (showtimeId != null){
            showtimeRepository.findById(showtimeId)
                    .stream().findFirst().map(
                    updatedShowtime -> {
                        updatedShowtime.setStartDate(putShowtimeDto.startDate());
                        updatedShowtime.setEndDate(putShowtimeDto.endDate());
                        updatedShowtime.setMovie(putShowtimeDto.movie());
                        updatedShowtime.setTheater(putShowtimeDto.theater());
                        Showtime showtime = showtimeRepository.save(updatedShowtime);
                        return new ResponseEntity<>(showtime, HttpStatus.OK);
                    }
            );
        }
        return showtimeRepository.findById(Objects.requireNonNull(showtimeId)).orElse(null);
    }
}
