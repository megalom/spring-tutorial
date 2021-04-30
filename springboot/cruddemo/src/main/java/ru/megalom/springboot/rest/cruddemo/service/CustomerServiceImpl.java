package ru.megalom.springboot.rest.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.megalom.springboot.rest.cruddemo.dao.CustomerDAO;
import ru.megalom.springboot.rest.cruddemo.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    @Qualifier("customerDAOJpaImpl")
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    @Transactional
    public Customer getById(int id) {
        return customerDAO.getById(id);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        customerDAO.deleteById(id);
    }
}
