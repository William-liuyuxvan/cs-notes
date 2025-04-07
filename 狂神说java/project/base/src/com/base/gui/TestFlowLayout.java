package com.base.gui;

import java.awt.*;

/**
 * @ClassName TestFlowLayout
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/7 14:52
 */
public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.add(new Button("btn1"));
        frame.add(new Button("btn2"));
        frame.add(new Button("btn3"));
        frame.add(new Button("btn4"));

        frame.pack();

        frame.setVisible(true);

    }
}
