package com.moviebooking.controller;

import com.moviebooking.dto.post.PostAdminDto;
import com.moviebooking.dto.put.PutAdminDto;
import com.moviebooking.entity.Admin;
import com.moviebooking.service.implementations.AdminServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/values/v1")
public class AdminController {
    private final AdminServiceImplementation adminServiceImplementation;

    @Autowired
    public AdminController(AdminServiceImplementation adminServiceImplementation) {
        this.adminServiceImplementation = adminServiceImplementation;
    }

    @PostMapping("/admins")
    public ResponseEntity<Admin> createAdmin(@RequestBody PostAdminDto postAdminDto) {
        Admin admin = adminServiceImplementation.createAdmin(postAdminDto);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }


    @GetMapping("/admins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminServiceImplementation.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("admins/{adminId}")
    public Admin getAdminById(@PathVariable Long adminId) {
        return adminServiceImplementation.findAdminById(adminId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/admins/{adminId}")
    public ResponseEntity<Admin> updateAdminById(@PathVariable Long adminId, @RequestBody PutAdminDto putAdminDto) {
        Admin updatedAdmin = adminServiceImplementation.updateAdminById(adminId, putAdminDto);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }
}


