package ru.megalom.springboot.rest.cruddemo.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.megalom.springboot.rest.cruddemo.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Customer",Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer customer=currentSession.get(Customer.class,id);
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query=currentSession.createQuery(
                "delete from Customer where id=:customerId"
        );
        query.setParameter("customerId",id);
        query.executeUpdate();
    }
}
