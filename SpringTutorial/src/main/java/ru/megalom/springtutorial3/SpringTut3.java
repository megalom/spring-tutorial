package ru.megalom.springtutorial3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTut3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        Dummy dummy=context.getBean("dummy",Dummy.class);
        DummyHive dummyHive=context.getBean("dummyHive",DummyHive.class);
        System.out.println(dummyHive);
        dummyHive.printDummy();
    }
}
