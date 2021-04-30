package ru.megalom.springMVCCustomer.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.megalom.springMVCCustomer.entity.Customer;

public class CreateCustomers {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating customers...");
            Customer customer1 = new Customer("Paul", "Doe", "paul@ya.ru");
            Customer customer2 = new Customer("Ivan", "Urgant", "vanya@ya.ru");
            Customer customer3 = new Customer("Lera", "Kudryavceva", "lera@ya.ru");
            Customer customer4 = new Customer("Tanya", "Golikova", "tanya@ya.ru");
            Customer customer5 = new Customer("Andrey", "Kaspersky", "andron@ya.ru");
            Customer customer6 = new Customer("Nikolai", "Baskov", "kolya@ya.ru");
            Customer customer7 = new Customer("Vladislav", "Sheremet", "vlad@ya.ru");
            // start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println("Saving customers...");
            session.save(customer1);
            session.save(customer2);
            session.save(customer3);
            session.save(customer4);
            session.save(customer5);
            session.save(customer6);
            session.save(customer7);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
