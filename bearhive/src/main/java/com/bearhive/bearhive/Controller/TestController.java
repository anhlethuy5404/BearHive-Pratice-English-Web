package com.bearhive.bearhive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bearhive.bearhive.Service.TestService;


@Controller
public class TestController {
    @Autowired
    private TestService testService; 

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("tests", testService.getAllTests());
        return "test";
    }

    @GetMapping("/ielts")
    public String getTestInfo(Model model) {
        return "ielts";
    }

    @GetMapping("/ielts/test")
    public String getTestContent() {
        return "ielts-test";
    }
    
}
