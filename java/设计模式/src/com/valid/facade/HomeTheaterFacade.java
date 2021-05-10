package com.valid.facade;

// 外观类
public class HomeTheaterFacade {
    private final DVDPlayer dvdPlayer = DVDPlayer.getInstance();
    private final Popcorn popcorn = Popcorn.getInstance();
    private final Projector projector = Projector.getInstance();
    private final Screen screen = Screen.getInstance();
    private final Stereo stereo = Stereo.getInstance();
    private final TheaterLight theaterLight = TheaterLight.getInstance();

    // 操作分为四部
    // 准备
    public void ready() {
        popcorn.on();
        popcorn.pop();
        screen.on();
        projector.on();
        stereo.on();
        dvdPlayer.on();
        theaterLight.down();
    }

    // 播放
    public void play() {
        dvdPlayer.play();
    }

    // 暂停
    public void pause() {
        dvdPlayer.pause();
    }

    // 结束
    public void end() {
        popcorn.off();
        screen.off();
        projector.off();
        stereo.off();
        dvdPlayer.off();
        theaterLight.up();
    }
}
