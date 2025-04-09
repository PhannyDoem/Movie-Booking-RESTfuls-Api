package com.moviebooking.mapper;

import com.moviebooking.dto.post.PostUserDto;
import com.moviebooking.dto.put.PutUserDto;
import com.moviebooking.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User postToUserDto(PostUserDto postUserDto){
        User user = new User(
                postUserDto.username(),
                postUserDto.email(),
                postUserDto.password()
        );
        user.setUserId(0L);
        return user;
    }

    public User updateUserDto(PutUserDto putUserDto){
        User user = new User(
                putUserDto.username(),
                putUserDto.email(),
                putUserDto.password()
        );
        user.setUserId(0L);
        return user;
    }
}
