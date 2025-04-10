package com.moviebooking.service.implementations;

import com.moviebooking.dto.post.PostUserDto;
import com.moviebooking.dto.put.PutUserDto;
import com.moviebooking.entity.User;
import com.moviebooking.mapper.UserMapper;
import com.moviebooking.repository.UserRepository;
import com.moviebooking.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Autowired
    public UserServiceImplementation(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public User addUser(PostUserDto postUserDto) {
        User user = userMapper.postToUserDto(postUserDto);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, PutUserDto putUserDto) {
        if (userId != null) {
            userRepository.findById(userId).map(
                    updatedUser -> {
                        updatedUser.setUsername(putUserDto.username());
                        updatedUser.setEmail(putUserDto.email());
                        updatedUser.setPassword(putUserDto.password());
                        User user = userRepository.save(updatedUser);
                        return userRepository.save(user);
                    }
            );
        }
        return userRepository.findById(Objects.requireNonNull(userId)).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        if (userId != null) {
            return userRepository.findById(userId);
        }
        return Optional.empty();
    }
}
