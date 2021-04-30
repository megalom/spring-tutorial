package ru.megalom.springboot.rest.cruddemo.service;

import ru.megalom.springboot.rest.cruddemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();
    public Customer getById(int id);
    public void save(Customer customer);
    public void deleteById(int id);
}
