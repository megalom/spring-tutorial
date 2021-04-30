package ru.megalom.springtutorial3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Dummy {
    @Value("${videoPlayer.name}")
    private String name;
    @Override
    public String toString(){
        return "This is dummy!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
