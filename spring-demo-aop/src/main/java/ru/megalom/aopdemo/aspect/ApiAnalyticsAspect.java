package ru.megalom.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class ApiAnalyticsAspect {
    @Before("ru.megalom.aopdemo.aspect.AopExpressions.daoAccountAdd()")
    public void beforeAddAccount(){
        System.out.println("=====>>> Executing analytics on addAccount()");
    }
}
