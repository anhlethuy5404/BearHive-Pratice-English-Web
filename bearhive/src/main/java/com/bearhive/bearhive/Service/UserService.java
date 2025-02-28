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
        Optional<User> existedUser = userRepository.findByEmail(email);
        if (existedUser.isPresent() && existedUser.get().getPassword().equals(password)) {
            return existedUser.get();
        }
        return null;
    }
}
