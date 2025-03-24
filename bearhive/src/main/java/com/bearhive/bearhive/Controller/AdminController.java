package com.bearhive.bearhive.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bearhive.bearhive.Model.Test;
import com.bearhive.bearhive.Model.User;
import com.bearhive.bearhive.Repository.TestRepository;
import com.bearhive.bearhive.Repository.UserRepository;




@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestRepository testRepository;
    
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
        model.addAttribute("subPage", "test-list");
        Optional<User> user = userRepository.findByEmail("thuyanh5404.kba@gmail.com");
        List<Test> tests;
        if (user.isPresent()) {
            tests = testRepository.findByUserId(user.get().getId());
        } else {
            tests = List.of();
            model.addAttribute("error", "Lỗi không thấy email ADMIN");
        }
        model.addAttribute("tests", tests);
        return "admininfo";
    }
    
    @GetMapping("/tests/create")
    public String createTest(Model model) {
        model.addAttribute("activePage", "tests");
        model.addAttribute("subPage", "test-create");
        model.addAttribute("test", new Test());
        return "admininfo";
    }
    
    @PostMapping("/tests/create")
    public String createTestSubmit(@ModelAttribute("test") Test test, Model model) {
        try {
            Optional<User> userOp = userRepository.findByEmail("thuyanh5404.kba@gmail.com");
            if (userOp.isPresent()) {
                User user = userOp.get();
                test.setUser(user);
            }
            else {
                model.addAttribute("error", "Lỗi không thấy email ADMIN");
            }
            if (test.getUpdateDate()==null) {
                test.setUpdateDate(LocalDate.now());
            }
            testRepository.save(test);
            return "redirect:/admin/tests";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            model.addAttribute("error", "Lỗi khi tạo test");
            model.addAttribute("activePage", "tests");
            model.addAttribute("subPage", "test-create");
            return "admininfo";
        }
    }
    
}
