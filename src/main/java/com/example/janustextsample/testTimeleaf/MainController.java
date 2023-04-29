package com.example.janustextsample.testTimeleaf;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/register")
    public String showForm(Model model) {
        TestDtoTimeleaf dto = new TestDtoTimeleaf();
        model.addAttribute("user", dto);
        System.out.println("show form method : " + dto);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") TestDtoTimeleaf dto) {
        System.out.println("submit form method : "+ dto);
        return "register_form";
    }

}
