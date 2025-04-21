package com.base.gui.two;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName TestTextField
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/7 21:29
 */
public class TestTextField {
    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyFrame extends Frame {
    public MyFrame() {
        TextField textField = new TextField();
        add(textField);

        MyMonitor myMonitor = new MyMonitor();
        textField.addActionListener(myMonitor);

        textField.setEchoChar('*');

        addWindowListener(myMonitor);

        pack();
        setVisible(true);
    }
}

class MyMonitor extends WindowAdapter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField textField = (TextField) e.getSource();
        System.out.println(textField.getText());
        textField.setText("");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
