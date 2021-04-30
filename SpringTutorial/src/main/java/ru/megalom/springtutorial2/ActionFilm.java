package ru.megalom.springtutorial2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActionFilm implements Film{
    private List<String> filmList;
    public ActionFilm(){
        filmList= new ArrayList<>();
        filmList.add("Terminator");
        filmList.add("Robocop");
        filmList.add("Die Hard");
    }
    @Override
    public String getName(int index) {
        return filmList.get(index);
    }
    @Override
    public String toString(){
        return filmList.toString();
    }
}
