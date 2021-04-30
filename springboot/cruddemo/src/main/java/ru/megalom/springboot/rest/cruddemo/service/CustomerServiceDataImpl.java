package ru.megalom.springboot.rest.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.megalom.springboot.rest.cruddemo.dao.CustomerRepository;
import ru.megalom.springboot.rest.cruddemo.entity.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceDataImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        Optional<Customer> result = customerRepository.findById(id);
        Customer customer = null;
        if(result.isPresent()){
            customer = result.get();
        }
        else{
            throw new RuntimeException("id not found");
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
