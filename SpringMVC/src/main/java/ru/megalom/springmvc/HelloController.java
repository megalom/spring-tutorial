package ru.megalom.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/helloWorld")
    public String sayHello(){
        return "helloWorld";
    }
}
