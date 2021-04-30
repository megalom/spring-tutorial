package ru.megalom.springboot.rest.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.megalom.springboot.rest.cruddemo.entity.Customer;
@RepositoryRestResource(path="customers")
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
