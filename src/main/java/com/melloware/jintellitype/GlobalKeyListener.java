package com.melloware.jintellitype;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class GlobalKeyListener{

    private Robot robot;
    private HotkeyListener hotkeyListener;
    static Opacity opacity;
    static GlobalKeyListener globalKeyListener;
    static String filename;

    public GlobalKeyListener(){
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
        this.addKey();
        this.addKeyEvent();
    }

    public void addKey(){
        JIntellitype.getInstance().registerHotKey(1, 0, 'K');
        JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_ALT, 'R');
    }

    public void clearKey(){
        JIntellitype.getInstance().unregisterHotKey(1);
        JIntellitype.getInstance().unregisterHotKey(2);
    }

    public void clearKeyEvent(){
        JIntellitype.getInstance().removeHotKeyListener(hotkeyListener);
    }

    public void addKeyEvent(){
        hotkeyListener = new HotkeyListener(){
            public void onHotKey(int code) {
                switch(code){
                    case 1:{
                        //先注销热键
                        clearKey();
                        //模拟按键原本功能
                        robot.keyPress(KeyEvent.VK_K);
                        robot.delay(50);
                        robot.keyRelease(KeyEvent.VK_K);
                        //这里写其他事件
                        System.out.println("按了K");
                        opacity.setContent("你是傻逼");
                        filename = "C:\\Users\\Administrator\\Desktop\\KBListenerFiles\\tts.mp3";
                        try
                        {
                            PlayThread.playThread.start();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }

                        //再重新注册热键
                        addKey();
                        break;
                    }
                    case 2:{
                        //这里写想实现的功能
                        System.out.println("按了alt+R");
                        break;
                    }
                }
            }};
        JIntellitype.getInstance().addHotKeyListener(hotkeyListener);
    }

    public static void main(String[] args) {
        opacity = new Opacity();
        GlobalKeyListener l = new GlobalKeyListener();
    }

}