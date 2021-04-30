package ru.megalom.thymeleafdemo.service;

import ru.megalom.thymeleafdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();
    public Customer getById(int id);
    public void save(Customer customer);
    public void deleteById(int id);
}
