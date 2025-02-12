package com.paintingscollectors.user.service;

import com.paintingscollectors.user.model.User;
import com.paintingscollectors.user.repository.UserRepository;
import com.paintingscollectors.web.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void registerUser(RegisterRequest registerRequest) {
        if (userRepository.findByUsernameOrEmail(registerRequest.getUsername(), registerRequest.getEmail()).isPresent()) {

            throw new RuntimeException("User with username or email already exists");
        }

        User user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .build();

        userRepository.save(user);
    }
}
