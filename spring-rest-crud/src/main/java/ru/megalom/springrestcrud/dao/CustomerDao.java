package ru.megalom.springrestcrud.dao;

import ru.megalom.springrestcrud.entity.Customer;

import java.util.List;

public interface CustomerDao {
        public List<Customer> getCustomers();
        public void saveCustomer(Customer customer);
        public Customer getCustomer(int id);

        public void deleteCustomer(int id);
}
