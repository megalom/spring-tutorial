package ru.megalom.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class FakeAccountDAO {
    public void addAccount() {
        System.out.println(getClass()+":DOING MY FAKE DB WORK: ADDING AN ACCOUNT");

    }
}
