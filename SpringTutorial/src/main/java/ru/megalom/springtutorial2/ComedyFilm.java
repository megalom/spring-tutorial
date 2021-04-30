package ru.megalom.springtutorial2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComedyFilm implements Film {
    private List<String> filmList;

    public ComedyFilm(){
        filmList= new ArrayList<>();
        filmList.add("Dumb and Dumber");
        filmList.add("Scary movie");
        filmList.add("Jay and Silent Bob");
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
