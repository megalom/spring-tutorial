package ru.megalom.springboot.demo.mycoolapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String sayHello(){
        String response="Hello from rest controller, the time on server is :";
        response+= LocalDateTime.now();
        return response;
    }
}
