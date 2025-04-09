package com.moviebooking.service.interfaces;

import com.moviebooking.dto.post.PostAdminDto;
import com.moviebooking.dto.put.PutAdminDto;
import com.moviebooking.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin createAdmin(PostAdminDto postAdminDto);
    List<Admin> getAllAdmins();
    Optional<Admin> findAdminById(Long adminId);
    Admin updateAdminById(Long adminId, PutAdminDto putAdminDto);
}
