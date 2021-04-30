package ru.megalom.springboot.rest.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.megalom.springboot.rest.cruddemo.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDAOJpaImpl implements CustomerDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getAll() {
        TypedQuery<Customer> theQuery = entityManager.createQuery("from Customer",Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public Customer getById(int id) {
        Customer customer = entityManager.find(Customer.class,id);
        if(customer==null){
            throw new RuntimeException("Customer not found id: "+id);
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Customer savedCustomer=entityManager.merge(customer);
        customer.setId(savedCustomer.getId());
    }

    @Override
    public void deleteById(int id) {
        Query theQuery = entityManager.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",id);
        theQuery.executeUpdate();
    }
}
