package com.bearhive.bearhive.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;






@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "main";
    }
    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home"; 
    }
    
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/flashcard")
    public String flashcard() {
        return "flashcard";
    }
    
    @GetMapping("/dictation")
    public String dictation() {
        return "dictation";
    }
    
}
