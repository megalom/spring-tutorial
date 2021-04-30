package ru.megalom.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggingAspect {
    @Before("ru.megalom.aopdemo.aspect.AopExpressions.daoAccountAdd()")
    public void logAccount(){
        System.out.println("=====>>>logging addAccount");
    }
}
