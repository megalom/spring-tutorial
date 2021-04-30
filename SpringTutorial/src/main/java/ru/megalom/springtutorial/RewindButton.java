package ru.megalom.springtutorial;

public class RewindButton implements PlayerButton{

    @Override
    public String push() {
        return "Rewind";
    }
    @Override
    public String toString(){
        return "Rewind";
    }
}
