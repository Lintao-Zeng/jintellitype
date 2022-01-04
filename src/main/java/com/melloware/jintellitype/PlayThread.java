package com.melloware.jintellitype;

public class PlayThread extends Thread{

    static PlayThread playThread = new PlayThread();

    @Override
    public void run(){
        try {
            Mymusic.playmusic(GlobalKeyListener.filename);
            playThread = new PlayThread();
        } catch (Exception e) {
            System.out.println("播放失败");
        }
    }
}
