package ru.megalom.springtutorial;

public class StopButton implements PlayerButton {

    @Override
    public String push() {
        return "Stop";
    }
    @Override
    public String toString(){
        return "Stop";
    }
}
