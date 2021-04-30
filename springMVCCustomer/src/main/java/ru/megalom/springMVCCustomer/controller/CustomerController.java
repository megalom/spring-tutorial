package ru.megalom.springMVCCustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.megalom.springMVCCustomer.dao.CustomerDAO;
import ru.megalom.springMVCCustomer.dao.CustomerDAOImpl;
import ru.megalom.springMVCCustomer.entity.Customer;
import ru.megalom.springMVCCustomer.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String listCustomers(Model model){
        List<Customer> customers=customerService.getCustomers();
        model.addAttribute("customers",customers);
        return "customer/customer";
    }

    @PostMapping()
    public String save(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "customer/add";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id") int id,Model model){
        Customer customer=customerService.getCustomer(id);
        model.addAttribute("customer",customer);
        return "customer/add";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id,Model model){
        customerService.deleteCustomer(id);
        return "redirect:/customer";
    }

}
