package com.bearhive.bearhive.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "main";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    
}
