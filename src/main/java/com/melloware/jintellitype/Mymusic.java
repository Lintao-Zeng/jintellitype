package com.melloware.jintellitype;

import jmp123.demo.MiniPlayer;

public class Mymusic {

    static void playmusic(String filename) throws Exception{
        MiniPlayer player = new MiniPlayer(new jmp123.output.Audio());
        player.open(filename);
        player.run();
    }
}
