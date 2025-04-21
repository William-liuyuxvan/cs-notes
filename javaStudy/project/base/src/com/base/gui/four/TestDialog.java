package com.base.gui.four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName TestDialog
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/8 15:16
 */
public class TestDialog extends JFrame {
    public TestDialog() {
        setBounds(100, 100, 450, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        JButton button = new JButton("btn");
        button.setBounds(20,20,10, 10);
        contentPane.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialog();
            }
        });
    }

    public static void main(String[] args) {
        new TestDialog();
    }
}

class MyDialog extends JDialog {
    public MyDialog() {
        setBounds(100, 100, 450, 300);
        setVisible(true);

        Container container = getContentPane();
        container.setLayout(new GridLayout(1,1));
        container.add(new Label("asdfasfasdf af asf "));
    }
}
