package com.base.gui.snakeDemo;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName StartGame
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/9 16:42
 */
public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(10, 10, 900, 720);
        frame.setResizable(false);

        frame.add(new GamePanel());
    }
}
