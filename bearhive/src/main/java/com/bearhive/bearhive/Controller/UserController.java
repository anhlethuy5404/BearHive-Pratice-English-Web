package com.bearhive.bearhive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bearhive.bearhive.Model.User;
import com.bearhive.bearhive.Repository.UserRepository;
import com.bearhive.bearhive.Service.UserService;


@Controller
public class UserController {
    @Autowired 
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/signup")
    public String getRegistrationPage(@ModelAttribute("user") User user, Model model) {
        return "signup";
    }
    
    @PostMapping("/signup")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        User savedUser = userService.registerUser(user);
        if (savedUser == null) {
            model.addAttribute("message", "Email đã được đăng kí!");
            return "signup";
        }
        else {
            model.addAttribute("message", "Đăng kí thành công!");
            return "signup";
        }
    }
}
