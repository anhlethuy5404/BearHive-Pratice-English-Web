package com.bearhive.bearhive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bearhive.bearhive.Service.DictationService;

@Controller
public class DictationController {
    @Autowired
    private DictationService dictationService; 

    @GetMapping("/dictation")
    public String dictation(Model model) {
        model.addAttribute("dictations", dictationService.getAllDictations()); 
        return "dictation";
    }

}
