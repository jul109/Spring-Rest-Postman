package com.example.demo.services.interfaces;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    boolean save(User user);
}
