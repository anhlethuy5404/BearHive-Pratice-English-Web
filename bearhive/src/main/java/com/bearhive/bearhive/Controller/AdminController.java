package com.bearhive.bearhive.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bearhive.bearhive.Model.User;
import com.bearhive.bearhive.Repository.UserRepository;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("activePage", "dashboard");
        return "admininfo";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("activePage", "users");
        List<User> users = userRepository.findByRole("USER");
        model.addAttribute("users", users);
        return "admininfo";
    }

    @GetMapping("/tests")
    public String tests(Model model) {
        model.addAttribute("activePage", "tests");
        return "admininfo";
    }
    
}
