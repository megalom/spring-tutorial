package ru.megalom.springtutorial2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class VideoPlayer {
    @Value("${videoPlayer.name}")
    private String name;
    @Value("${videoPlayer.volume}")
    private int volume;
    //@Qualifier("actionFilm")
    @Autowired
    @Qualifier("actionFilm")
    Film ActionFilms;
    @Autowired
    @Qualifier("comedyFilm")
    Film ComedyFilms;

    String currentFilm;

    public void doMyInit(){
        System.out.println("doing my initialization.");
    }


    //Constructor
    public VideoPlayer(){
        currentFilm="No film is currently playing.";
    }
    //Get current Film
    public String getCurrentFilm() {
        return currentFilm;
    }
    //Play film in chosen genre
    public void Play(Genre genre){
        switch (genre){
            case ACTION:
                currentFilm=getRandomMovie(ActionFilms);
                break;
            case COMEDY:
                currentFilm=getRandomMovie(ComedyFilms);
                break;
            default:
                break;
        }
        System.out.println("Playing movie "+currentFilm);
    }
    private String getRandomMovie(Film film){
        Random random = new Random();
        int r = random.nextInt(3);
        System.out.println(r);
        String result =film.getName(r);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString(){
       //return "Action film = "+actionFilm+", comedy film = "+comedyFilm;
        return "Video player showing "+currentFilm+"\nPlayer name="+name+"\nVolume = "+volume;
    }
}
