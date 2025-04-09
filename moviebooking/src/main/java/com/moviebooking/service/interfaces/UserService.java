package com.moviebooking.service.interfaces;

import com.moviebooking.dto.post.PostUserDto;
import com.moviebooking.dto.put.PutUserDto;
import com.moviebooking.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(PostUserDto postUserDto);
    User updateUser(PutUserDto putUserDto);
    List<User> getAllUsers();
    Optional<User> getUserById(Long userId);
}
