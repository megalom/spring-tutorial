package ru.megalom.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.megalom.thymeleafdemo.entity.Customer;
import ru.megalom.thymeleafdemo.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping()
    public String getCustomers(Model model){
        List<Customer> customers=customerService.getAll();
        model.addAttribute("customers",customers);
        return "customers/customers-list";
    }

    @GetMapping("/add")
    public String addCustomerForm(Model model){
        Customer customer=new Customer();
        model.addAttribute("customer", customer);
        return "customers/add-customer";
    }

    @GetMapping("/update")
    public String addCustomerUpdateForm(Model model, @RequestParam("customerId") int id){
        model.addAttribute("customer",customerService.getById(id) );
        return "customers/add-customer";
    }

    @GetMapping("/delete")
    public String deleteCustomer(Model model,@RequestParam("customerId") int id){
        customerService.deleteById(id);
        return "redirect:/customers";
    }

    @PostMapping()
    public String saveCustomer(Model model, @ModelAttribute("customer") Customer customer){
       customerService.save(customer);
        return "redirect:/customers";
    }

}
