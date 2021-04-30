package ru.megalom.springboot.rest.cruddemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.megalom.springboot.rest.cruddemo.dao.CustomerDAO;
import ru.megalom.springboot.rest.cruddemo.entity.Customer;
import ru.megalom.springboot.rest.cruddemo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerRestController {
    @Autowired
    @Qualifier("customerServiceDataImpl")
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> findAllCustomers(){
        return customerService.getAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") int id){
        Customer customer = customerService.getById(id);
        if(customer==null){
            throw new RuntimeException("Customer id not found "+id);
        }
        return customerService.getById(id);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody() Customer customer){
        customer.setId(0);
        customerService.save(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody() Customer customer){
        customerService.save(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        Customer customer = customerService.getById(id);
        if(customer==null){
            throw new RuntimeException("Customer not found, id - "+id);
        }
        customerService.deleteById(id);
        return "deleted customer: "+id;
    }

}
