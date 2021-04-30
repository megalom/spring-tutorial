package ru.megalom.springboot.demo.mycoolapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloWorldController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello(){
        String response="Hello from rest controller, the time on server is :";
        response+= LocalDateTime.now();
        response+="\nCoach name: "+coachName;
        response+="\nTeam name: "+teamName;
        return response;
    }
}
