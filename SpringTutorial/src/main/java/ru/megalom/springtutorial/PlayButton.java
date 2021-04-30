package ru.megalom.springtutorial;

public class PlayButton implements PlayerButton{
    @Override
    public String push() {
        return "Play";
    }
    @Override
    public String toString(){
        return "Play";
    }
}
