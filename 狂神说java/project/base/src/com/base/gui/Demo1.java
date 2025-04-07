package com.base.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/7 15:07
 */
public class Demo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("frame1");

        frame.setSize(600,400);
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();

        frame.setLayout(new GridLayout(2, 1));

        panel1.setLayout(null);
        panel2.setLayout(null);
        panel1.setBackground(Color.BLUE);
        panel2.setBackground(Color.red);

        // 设置panel1 上面的整体布局
        panel1.setLayout(new BorderLayout());
        Panel panel3 = new Panel();
        panel1.add(new Button("btn"), BorderLayout.WEST);
        panel1.add(panel3, BorderLayout.CENTER);
        panel1.add(new Button("btn"), BorderLayout.EAST);

        panel3.setLayout(new GridLayout(2, 1));
        panel3.add(new Button("btn"));
        panel3.add(new Button("btn"));

        // 设置panel2 下面的整体布局
        panel2.setLayout(new BorderLayout());
        Panel panel4 = new Panel();
        panel2.add(new Button("btn"), BorderLayout.WEST);
        panel2.add(panel4, BorderLayout.CENTER);
        panel2.add(new Button("btn"), BorderLayout.EAST);

        panel4.setLayout(new GridLayout(2, 2));
        panel4.add(new Button("btn"));
        panel4.add(new Button("btn"));
        panel4.add(new Button("btn"));
        panel4.add(new Button("btn"));

        frame.add(panel1);
        frame.add(panel2);

        frame.setVisible(true);

        frame.pack();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
