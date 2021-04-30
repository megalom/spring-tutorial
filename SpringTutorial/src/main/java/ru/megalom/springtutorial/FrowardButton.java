package ru.megalom.springtutorial;

public class FrowardButton implements PlayerButton{
    @Override
    public String push() {
        return "Play Forward";
    }
    @Override
    public String toString(){
        return "Forward";
    }
}
