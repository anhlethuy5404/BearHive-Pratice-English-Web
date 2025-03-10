package com.bearhive.bearhive.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bearhive.bearhive.Model.User;
import com.bearhive.bearhive.Repository.UserRepository;
import com.bearhive.bearhive.Util.AvatarUtil;

import jakarta.servlet.http.HttpSession;

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
    
    public User loginUser(String email, String password, HttpSession session) {
        Optional<User> existedUser = userRepository.findByEmail(email);
        if (existedUser.isPresent() && existedUser.get().getPassword().equals(password)) {
            User user = existedUser.get();
            if (user.getAvatar() == null || user.getAvatar().isEmpty()) {
                String randomAvt = AvatarUtil.getRandomAvatar();
                user.setAvatar(randomAvt);
                userRepository.save(user);
            }
            session.setAttribute("loggedUser", user);
            return user;
        }
        return null;
    }

    public void updatePassword(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow();
        user.setPassword(password);
        userRepository.save(user);
    }

}
