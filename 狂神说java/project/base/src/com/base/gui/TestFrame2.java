package com.base.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName TestFrame2
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/7 11:51
 */
public class TestFrame2 {
    public static void main(String[] args) {
        new MyFrame(100, 100, 200, 200, Color.BLUE);
        new MyFrame(300, 100, 200, 200, Color.YELLOW);
        new MyFrame(100, 300, 200, 200, Color.ORANGE);
        new MyFrame(300, 300, 200, 200, Color.GRAY);
    }
}

class MyFrame extends Frame {
    static int id = 0;

    public MyFrame(int x, int y, int w, int h, Color color) {
        super(""+(++id));
        setVisible(true);
        setBounds(x, y, w, h);
        setBackground(color);
    }
}