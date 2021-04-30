package ru.megalom.aopdemo.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.megalom.aopdemo.config.DemoConfig;
import ru.megalom.aopdemo.dao.AccountDAO;
import ru.megalom.aopdemo.dao.FakeAccountDAO;

import java.util.ArrayList;
import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();

        //read spring config java class
        AnnotationConfigApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from spring context
        AccountDAO accountDAO = applicationContext.getBean("accountDAO",AccountDAO.class);
        FakeAccountDAO faccountDAO = applicationContext.getBean("fakeAccountDAO",FakeAccountDAO.class);
        //call the business  method
        accountDAO.addAccount(new Account("first",1001),true);
        //doing fake account
        faccountDAO.addAccount();
        //List<Account> accountList=accountDAO.findAccount(1);
        // do it again
        accountDAO.addAccount(new Account("Second",2001),true);
        try {
            accountList = accountDAO.findAccount(1);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("\nMain=> Accounts:");
        for (Account tmp:accountList){
            System.out.println(tmp.getName()+" "+tmp.getNumber());
        }
        //close the context
        applicationContext.close();
    }
}
