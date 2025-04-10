package com.moviebooking.controller;

import com.moviebooking.dto.post.PostUserDto;
import com.moviebooking.dto.put.PutUserDto;
import com.moviebooking.entity.User;
import com.moviebooking.service.implementations.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/values/v1")
public class UserController {
    private final UserServiceImplementation userServiceImplementation;
    @Autowired
    public UserController(UserServiceImplementation userServiceImplementation) {
        this.userServiceImplementation = userServiceImplementation;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody PostUserDto postUserDto) {
        User user = userServiceImplementation.addUser(postUserDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId,@RequestBody PutUserDto putUserDto) {
        User user = userServiceImplementation.updateUser(userId,putUserDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServiceImplementation.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long userId) {
        Optional<User> user = userServiceImplementation.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
