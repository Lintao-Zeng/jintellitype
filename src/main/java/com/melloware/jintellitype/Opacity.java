package com.melloware.jintellitype;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class Opacity extends JFrame {
     int xOld = 0;
     int yOld = 0;
     int xx = 0;
     int yy = 0;

    Font font = new Font("none", 0, 40);
    JLabel jLabel = new JLabel("", JLabel.CENTER);

        public void setContent(String content){
            jLabel.setText(content);
        }

        Opacity() {
        this.setTitle("窗体透明化测试");
        this.setAlwaysOnTop(true);
        this.getContentPane().setBackground(Color.white);

        jLabel.setFont(font);
        jLabel.setBounds(this.getBounds());
        jLabel.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
        jLabel.setBackground(Color.white);
        jLabel.setForeground(Color.red);
        this.add(jLabel);

        // 判断是否支持透明度
        this.setUndecorated(true); // 禁用或启用此窗体的修饰。只有在窗体不可显示时
        //才调用此方法。
        if (com.sun.awt.AWTUtilities.isWindowOpaque(this)) {
            com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.4F);
        } else {
            JOptionPane.showMessageDialog(this, "系统不支持 JDK版本过低或 JRE 系统库缺损");
        }

        this.setBounds(600,80,800,60);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);


        //处理拖动事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOld = e.getX();
                yOld = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xOnScreen = e.getXOnScreen();
                int yOnScreen = e.getYOnScreen();
                xx = xOnScreen - xOld;
                yy = yOnScreen - yOld;
                Opacity.this.setBounds(xx,yy,Opacity.this.getBounds().width,Opacity.this.getBounds().height);
            }
        });

    }
}
