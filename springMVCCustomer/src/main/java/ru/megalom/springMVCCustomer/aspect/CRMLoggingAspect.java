package ru.megalom.springMVCCustomer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class CRMLoggingAspect {

    //setup logger
    private Logger logger=Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* ru.megalom.springMVCCustomer.controller.*.*(..))")
    private void forControllerPackage(){}
    @Pointcut("execution(* ru.megalom.springMVCCustomer.service.*.*(..))")
    private void forServicePackage(){}
    @Pointcut("execution(* ru.megalom.springMVCCustomer.dao.*.*(..))")
    private void forDaoPackage(){}
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    //add @Before advice
    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint){
        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>> in @Before: calling method: "+method);
        //display the arguments to the method
        Object[] args=joinPoint.getArgs();
        //loop thru and display args
        for(Object tmp:args){
            logger.info("=====>> argument: "+tmp);
        }
    }

    //add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    private void after(JoinPoint joinPoint,Object theResult){
        //display method we are returned from
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>> in @AfterReturning: from method: "+method);

        //display data returned
        logger.info("=====>> result: "+theResult);
    }
}
