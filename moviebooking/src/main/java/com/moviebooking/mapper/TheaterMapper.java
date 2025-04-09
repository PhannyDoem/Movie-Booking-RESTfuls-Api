package com.moviebooking.mapper;

import com.moviebooking.dto.post.PostTheaterDto;
import com.moviebooking.dto.put.PutTheaterDto;
import com.moviebooking.entity.Theater;
import org.springframework.stereotype.Service;

@Service
public class TheaterMapper {
    public Theater postToTheaterDto(PostTheaterDto postTheaterDto) {
        Theater theater = new Theater(
                postTheaterDto.name(),
                postTheaterDto.location()
        );
        theater.setTheaterId(0L);
        return theater;
    }

    public Theater updateTheaterDto(PutTheaterDto putTheaterDto) {
        Theater theater = new Theater(
                putTheaterDto.name(),
                putTheaterDto.location()
        );
        theater.setTheaterId(0L);
        return theater;
    }
}
