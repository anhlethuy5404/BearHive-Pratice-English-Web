package com.bearhive.bearhive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginForm(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        User user = userService.loginUser(email, password);
        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "Email hoặc mật khẩu không đúng!");
            return "redirect:/login";  
        }
        return "redirect:/home";   
    }
    
}
