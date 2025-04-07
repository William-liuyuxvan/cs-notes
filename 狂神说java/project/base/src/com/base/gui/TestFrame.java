package com.base.gui;

import java.awt.*;

/**
 * @ClassName TestFrame
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/7 11:45
 */
public class TestFrame {
    public static void main(String[] args) {
        // 1.创建对象
        Frame frame = new Frame("yuxuan的第一个frame");

        // 2.设置可见性
        frame.setVisible(true);

        // 3.设置初始位置，大小
        frame.setBounds(200, 200, 300, 300);

        // 4.设置颜色
        frame.setBackground(Color.BLUE);

        // 5.设置是否可以改变窗口大小
        frame.setResizable(false);

    }
}
