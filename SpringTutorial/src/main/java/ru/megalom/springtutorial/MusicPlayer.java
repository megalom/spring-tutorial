package ru.megalom.springtutorial;

import java.util.List;

public class MusicPlayer {


    private String name;
    private int volume;
    private Music music;

    public void doMyInit(){
        System.out.println("My init");
    }

    public void doMyDestroy(){
        System.out.println("My destruction");
    }

    public List<PlayerButton> getPlayerButtons() {
        return playerButtons;
    }

    public void setPlayerButtons(List<PlayerButton> playerButtons) {
        this.playerButtons = playerButtons;
    }

    private List<PlayerButton> playerButtons;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }



    public MusicPlayer(){
    }

    //IoC
    public MusicPlayer(Music music){
        this.music = music;
    }

    public void playMusic(){
        System.out.println("Playing "+music.getSong());
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
        return "Player "+name+" play music "+music.getSong()+" at volume "+volume+" has a buttons: "+playerButtons;
    }
}
