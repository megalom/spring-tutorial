package ru.megalom.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.megalom.aopdemo.application.Account;

@Aspect
@Order(1)
@Component
public class BeforeAdviceAspect {


    //this is where we add all of our related advices for logging
    //let's start with an @Before advice
    // pattern: execution( modifier(not necessary), return type(can be *), fully qualifiedName(not necessary)
    // , method name() (always),throws(not necessary)
    //pointcut can be combined: && || !
    // poincut can be created using another pointcut||combinerd pointcut
    @Before("ru.megalom.aopdemo.aspect.AopExpressions.daoAccountAdd()")
    public void beforeAddAccount(JoinPoint joinPoint){
        System.out.println("\n=====>>> Executing @Before advice method on addAccount()");
        //display method signature
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+methodSignature);
        //display method args
        Object[] args = joinPoint.getArgs();
        for(Object tmp:args){
            System.out.println(tmp);
            if(tmp instanceof Account){
                Account tmp2=(Account) tmp;
                System.out.println(String.format("Account = %s,%s",tmp2.getName(),tmp2.getNumber()));
            }
        }
        System.out.println("");
    }
}
