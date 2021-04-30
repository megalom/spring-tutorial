package ru.megalom.thymeleafdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.megalom.thymeleafdemo.dao.CustomerRepository;
import ru.megalom.thymeleafdemo.entity.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {

        return customerRepository.findAllByOrderByLastNameAsc();
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
