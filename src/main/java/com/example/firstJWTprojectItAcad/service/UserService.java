package com.example.firstJWTprojectItAcad.service;

import com.example.firstJWTprojectItAcad.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.firstJWTprojectItAcad.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUser(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

}
