package ru.megalom.springtutorial2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    int id;
    VideoPlayer videoPlayer;
    @Autowired
    public Computer(VideoPlayer videoPlayer){
        this.id=1;
        this.videoPlayer=videoPlayer;
    }

    public VideoPlayer getVideoPlayer(){
        return videoPlayer;
    }
    @Override
    public String toString(){
        return "Computer id="+id+" "+videoPlayer;
    }
}
