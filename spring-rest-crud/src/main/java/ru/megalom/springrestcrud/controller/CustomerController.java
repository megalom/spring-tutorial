package ru.megalom.springrestcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.megalom.springrestcrud.entity.Customer;
import ru.megalom.springrestcrud.exception.CustomerNotFoundException;
import ru.megalom.springrestcrud.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomers(@PathVariable("id") int id){
        Customer response=customerService.getCustomer(id);
        if(response==null)
            throw new CustomerNotFoundException("No matching results.");
        return response;
    }

    @PostMapping()
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping()
    public Customer updateCustomer(@RequestBody Customer customer){

        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {

        Customer customer=customerService.getCustomer(id);

        if(customer==null){
            throw new CustomerNotFoundException("Customer id not found - "+id);
        }

        customerService.deleteCustomer(id);
        return "Deleted customer id - "+id;
    }

}
