package com.example.hospitalmanagementsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NurseLoginController {
    @GetMapping("/nurses/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/nurses/login-error")
    public String onFailure(
            @ModelAttribute("username") String username,
            Model model) {

        model.addAttribute("username", username);
        model.addAttribute("bad_credentials", "true");

        return "auth-login";
    }
}
