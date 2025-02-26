package com.bearhive.bearhive.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bearhive.bearhive.Model.User;
import com.bearhive.bearhive.Repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        Optional<User> existedUser = userRepository.findByEmail(user.getEmail());
        if (existedUser.isPresent()) {
            return null;
        }
        user.setRole("USER");
        return userRepository.save(user);
    }
    
    public User loginUser(String email, String password) {
        return userRepository.findByEmail(email)
            .filter(user -> user.getPassword().equals(password))
            .orElse(null);
    }
}
