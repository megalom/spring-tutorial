package ru.megalom.springtutorial3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.megalom.springtutorial3")
@PropertySource("classpath:videoPlayer.properties")
public class SpringConfig {
    @Bean
    public Dummy dummy(){
        return new Dummy();
    }
    @Bean
    public DummyHive dummyHive(){
        return new DummyHive(dummy());
    }

}
