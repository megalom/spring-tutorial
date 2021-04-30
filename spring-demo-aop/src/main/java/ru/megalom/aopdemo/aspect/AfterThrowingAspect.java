package ru.megalom.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingAspect {
    @AfterThrowing(pointcut = "execution(* ru.megalom.aopdemo.dao.AccountDAO.findAccount(..))",
    throwing = "e")
    public void afterThrowingWork(JoinPoint joinPoint,Throwable e){
        System.out.println("exception: "+e.toString()+" message: "+e.getMessage());
    }
}
