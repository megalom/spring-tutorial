package ru.megalom.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(public void ru.megalom.aopdemo.dao.AccountDAO.addAccount(..))")
    public void daoAccountAdd(){}
}
