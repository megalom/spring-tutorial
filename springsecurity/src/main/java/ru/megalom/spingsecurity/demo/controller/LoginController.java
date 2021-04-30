package ru.megalom.spingsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm(){

        return "fancy-login";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){

        return "access-denied";
    }
}
