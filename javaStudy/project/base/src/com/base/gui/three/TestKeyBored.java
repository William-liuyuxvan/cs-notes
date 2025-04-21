package com.base.gui.three;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @ClassName TestKeyBored
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/8 14:26
 */
public class TestKeyBored {
    public static void main(String[] args) {
        new MyKeyFrame();
    }
}

class MyKeyFrame extends Frame {
    public MyKeyFrame() {
        setVisible(true);
        setBounds(100, 100, 450, 300);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                } else if (code == KeyEvent.VK_ENTER) {
                    System.out.println("ENTER");
                }
            }
        });
    }
}