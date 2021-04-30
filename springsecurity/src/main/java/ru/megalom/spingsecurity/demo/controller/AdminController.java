package ru.megalom.spingsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/system")
    public String getLeaders(){
        return "system";
    }
}
