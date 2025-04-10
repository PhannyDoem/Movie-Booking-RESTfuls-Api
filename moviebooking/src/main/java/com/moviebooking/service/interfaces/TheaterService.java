package com.moviebooking.service.interfaces;

import com.moviebooking.dto.post.PostTheaterDto;
import com.moviebooking.dto.put.PutTheaterDto;
import com.moviebooking.entity.Theater;

import java.util.List;
import java.util.Optional;

public interface TheaterService {
    Theater createTheater(PostTheaterDto postTheaterDto);
    List<Theater> getAllTheaters();
    Optional<Theater> getTheaterById(Long theaterId);
    Theater updateTheater(Long theaterId,PutTheaterDto putTheaterDto);
}
