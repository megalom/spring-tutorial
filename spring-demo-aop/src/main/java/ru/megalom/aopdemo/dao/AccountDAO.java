package ru.megalom.aopdemo.dao;

import org.springframework.stereotype.Component;
import ru.megalom.aopdemo.application.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    List<Account> account;
    public AccountDAO(){
        account=new ArrayList<>();
    }
    public void addAccount(Account acc,boolean b) {
        System.out.println(String.format("Account %s was created, No: %s",acc.getName(),acc.getNumber()));
        System.out.println(getClass()+":DOING MY DB WORK: ADDING AN ACCOUNT");
        account.add(acc);

    }
    public List<Account> findAccount(int number){
        if(number==1)
            throw new RuntimeException("No soup for you!!!");
        return account;
    }
}