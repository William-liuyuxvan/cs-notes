package com.base.gui.five;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName TestJPanel
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/8 17:36
 */
public class TestJPanel extends JFrame {

    public TestJPanel() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2, 10,10));
        JPanel jPanel1 = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(2, 1, 1,1));

        jPanel1.add(new JButton("1"));
        jPanel1.add(new JButton("1"));
        jPanel2.add(new JButton("2"));
        jPanel2.add(new JButton("2"));

        container.add(jPanel1);
        container.add(jPanel2);

    }

    public static void main(String[] args) {
        new TestJPanel();
    }
}
