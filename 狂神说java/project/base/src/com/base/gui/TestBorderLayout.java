package com.base.gui;

import java.awt.*;

/**
 * @ClassName TestFlowLayout
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/7 14:52
 */
public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.setLayout(new BorderLayout());

        frame.add(new Button("EAST"), BorderLayout.EAST);
        frame.add(new Button("WEST"), BorderLayout.WEST);
        frame.add(new Button("CENTER"), BorderLayout.CENTER);
        frame.add(new Button("SOUTH"), BorderLayout.SOUTH);
        frame.add(new Button("NORTH"), BorderLayout.NORTH);

        frame.pack();

        frame.setVisible(true);

    }
}
