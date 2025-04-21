package com.base.gui.five;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @ClassName TestIconButton
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/9 14:38
 */
public class TestJPasswordField extends JFrame {

    public TestJPasswordField() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JPasswordField passwordField = new JPasswordField(20);

        getContentPane().add(passwordField);
    }

    public static void main(String[] args) {
        new TestJPasswordField();
    }
}