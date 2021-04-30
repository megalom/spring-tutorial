package ru.megalom.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello"+name+surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            Model model){
        model.addAttribute("message","Hello "+name+" "+surname);
        //System.out.println("Goodbye "+name+" - "+surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate( @RequestParam(value = "a", required = false) String a,
                             @RequestParam(value = "b", required = false) String b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model){
        int a1=Integer.parseInt(a);
        int b1=Integer.parseInt(b);
        String response="The operation: ";

        switch (action){
            case "multiplication":
                response+=a1+" * "+b1+"="+(a1*b1);
                break;
            case "addition":
                response+=a1+" + "+b1+"="+(a1+b1);
                break;
            case "subtraction":
                response+=a1+" - "+b1+"="+(a1-b1);
                break;
            case "division":
                response+=a1+" / "+b1+"="+(a1/b1);
                break;
            default:
                response="Unknown action";
        }

        model.addAttribute("result", response);
        return "first/calculator";
    }
}
