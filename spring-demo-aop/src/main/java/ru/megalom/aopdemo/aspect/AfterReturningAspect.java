package ru.megalom.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.megalom.aopdemo.application.Account;

import java.util.List;

@Component
@Aspect
public class AfterReturningAspect {
    @AfterReturning(pointcut="execution(* ru.megalom.aopdemo.dao.AccountDAO.findAccount(..))",
            returning="result")
    public void afterReturnFindAccountAdvice(JoinPoint joinPoint, List<Account> result){
        System.out.println("\n=====>Executing after return account.\n Result:");
        for(Account tmp:result){
            System.out.println(String.format("Account name: %s, number: %s",tmp.getName(),tmp.getNumber()));
            tmp.setName("Vasya");
        }
        System.out.println("");

    }
}
