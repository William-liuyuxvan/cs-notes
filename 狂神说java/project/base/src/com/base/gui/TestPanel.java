package com.base.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName TestPanel
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/7 14:31
 */
public class TestPanel {
    public static void main(String[] args) {
        // new对象
        Frame frame = new Frame("Test Panel");
        Panel panel = new Panel();

        // 设置布局
        frame.setLayout(null);

        // 设置坐标
        frame.setBounds(200, 200, 300, 300);
        frame.setBackground(Color.gray);

        // 设置panel坐标，相对于frame
        panel.setBounds(50,50,200,200);
        panel.setBackground(Color.BLUE);

        // panel放入frame中
        frame.add(panel);

        // 可见性
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                // 关闭界面
                System.exit(0);
            }
        });

    }
}
