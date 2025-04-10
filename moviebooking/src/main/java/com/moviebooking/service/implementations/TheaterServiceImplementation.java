package com.moviebooking.service.implementations;

import com.moviebooking.dto.post.PostTheaterDto;
import com.moviebooking.dto.put.PutTheaterDto;
import com.moviebooking.entity.Theater;
import com.moviebooking.mapper.TheaterMapper;
import com.moviebooking.repository.TheaterRepository;
import com.moviebooking.service.interfaces.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TheaterServiceImplementation implements TheaterService {
    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;

    @Autowired
    public TheaterServiceImplementation(TheaterRepository theaterRepository, TheaterMapper theaterMapper) {
        this.theaterRepository = theaterRepository;
        this.theaterMapper = theaterMapper;
    }

    @Override
    public Theater createTheater(PostTheaterDto postTheaterDto) {
        Theater theater = theaterMapper.postToTheaterDto(postTheaterDto);
        return theaterRepository.save(theater);
    }

    @Override
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public Optional<Theater> getTheaterById(Long theaterId) {
        if (theaterId != null) {
            return theaterRepository.findById(theaterId);
        }
        return Optional.empty();
    }

    @Override
    public Theater updateTheater(Long theaterId, PutTheaterDto putTheaterDto) {
        if (theaterId != null){
            theaterRepository.findById(theaterId).map(
                    updatedTheater -> {
                        updatedTheater.setName(putTheaterDto.name());
                        updatedTheater.setLocation(putTheaterDto.location());
                        Theater theater = theaterRepository.save(updatedTheater);
                        return theaterRepository.save(theater);
                    }
            );
        }
        return theaterRepository.findById(Objects.requireNonNull(theaterId)).orElse(null);
    }
}
