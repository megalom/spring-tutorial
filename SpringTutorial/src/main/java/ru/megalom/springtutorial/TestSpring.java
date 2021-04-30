package ru.megalom.springtutorial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        /*
        TestBean testBean = context.getBean("testBean",TestBean.class);
        System.out.println(testBean.getName());
         */
        //Music music = context.getBean("musicBean",Music.class);
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        showPlayer(musicPlayer,"first");
        showPlayer(secondMusicPlayer,"second");

        musicPlayer.setVolume(90);

        showPlayer(musicPlayer,"first");
        showPlayer(secondMusicPlayer,"second");

        MusicPlayer thirdMusicPlayer = context.getBean("musicPlayerProto", MusicPlayer.class);
        MusicPlayer fourthMusicPlayer = context.getBean("musicPlayerProto", MusicPlayer.class);

        showPlayer(thirdMusicPlayer,"third");
        showPlayer(fourthMusicPlayer,"fourth");
        thirdMusicPlayer.setVolume(80);

        showPlayer(thirdMusicPlayer,"third");
        showPlayer(fourthMusicPlayer,"fourth");


        //musicPlayer.playMusic();

        context.close();
    }

    public static void showPlayer(MusicPlayer player, String name){
        System.out.println(name+" player:");
        System.out.println(player);
    }
}
