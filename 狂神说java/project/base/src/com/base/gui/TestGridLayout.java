package com.base.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName TestFlowLayout
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/7 14:52
 */
public class TestGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.setLayout(new GridLayout(2,3));

        frame.add(new Button("EAST1"));
        frame.add(new Button("WEST2"));
        frame.add(new Button("WEST3"));
        frame.add(new Button("WEST4"));
        frame.add(new Button("WEST5"));
        frame.add(new Button("WEST6"));

        frame.pack();

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
