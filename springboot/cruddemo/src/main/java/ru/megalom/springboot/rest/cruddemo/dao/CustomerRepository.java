package ru.megalom.springboot.rest.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.springboot.rest.cruddemo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
