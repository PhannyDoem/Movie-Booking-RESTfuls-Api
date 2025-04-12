package com.moviebooking.service.implementations;

import com.moviebooking.dto.post.PostAdminDto;
import com.moviebooking.dto.put.PutAdminDto;
import com.moviebooking.entity.Admin;
import com.moviebooking.repository.AdminRepository;
import com.moviebooking.mapper.AdminMapper;
import com.moviebooking.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminServiceImplementation implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Autowired
    public AdminServiceImplementation(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin createAdmin(PostAdminDto postAdminDto) {
        Admin admin = adminMapper.postToAdminDto(postAdminDto);
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findAdminById(Long adminId) {
        if (adminId != null) {
            return adminRepository.findById(adminId);
        }
        return Optional.empty();
    }

    @Override
    public Admin updateAdminById(Long adminId, PutAdminDto putAdminDto) {
        if (adminId != null) {
             adminRepository
                     .findById(adminId)
                     .stream()
                     .findFirst()
                     .map(
                    updateAdmin -> {
                        updateAdmin.setUsername(putAdminDto.username());
                        updateAdmin.setEmail(putAdminDto.email());
                        updateAdmin.setPassword(putAdminDto.password());
                        Admin updatedAdmin = adminRepository.save(updateAdmin);
                        return adminRepository.save(updatedAdmin);
                    }
            );
        }
        return adminRepository.findById(Objects.requireNonNull(adminId)).orElse(null);
    }
}
