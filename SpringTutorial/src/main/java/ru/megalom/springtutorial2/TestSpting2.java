package ru.megalom.springtutorial2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpting2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext2.xml");
        /*
        Film currentFilm = context.getBean("actionFilm",Film.class);
        System.out.println(currentFilm.getName());
        currentFilm = context.getBean("comedyFilm",Film.class);
        System.out.println(currentFilm.getName());*/

        Computer computer=context.getBean("computer",Computer.class);
        System.out.println(computer);
        computer.getVideoPlayer().Play(Genre.ACTION);
        computer.getVideoPlayer().Play(Genre.COMEDY);
        computer.getVideoPlayer().Play(Genre.ACTION);
        computer.getVideoPlayer().Play(Genre.COMEDY);
    }
}
