package com.base.gui.four;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @ClassName TestImageIcon
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/8 16:59
 */
public class TestImageIcon extends JFrame {
    public static void main(String[] args) {
        new TestImageIcon().init();
    }

    private void init() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JLabel jLabel = new JLabel("a ");
        URL url = TestImageIcon.class.getResource("lyx.jpeg");

        System.out.println(url);

        ImageIcon imageIcon = new ImageIcon(url);

        jLabel.setIcon(imageIcon);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        getContentPane().add(jLabel);
    }
}

