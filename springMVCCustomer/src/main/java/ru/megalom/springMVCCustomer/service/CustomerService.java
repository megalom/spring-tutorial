package ru.megalom.springMVCCustomer.service;

import ru.megalom.springMVCCustomer.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);
}
