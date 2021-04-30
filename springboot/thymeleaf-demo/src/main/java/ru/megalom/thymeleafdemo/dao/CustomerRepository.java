package ru.megalom.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.thymeleafdemo.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public List<Customer> findAllByOrderByLastNameAsc();
}
