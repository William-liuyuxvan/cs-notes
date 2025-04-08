package com.base.gui.two;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/7 21:43
 */
public class Demo1 {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}

class Calculator extends Frame {
    TextField num1;
    TextField num2;
    TextField num3;

    public void loadFrame() {
        setTitle("Calculator");

        // 三个文本框
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(10);
        // 一个label +
        Label label = new Label("+");
        // 一个按钮 =
        Button button = new Button("=");

        // 流式添加到frame中
        setLayout(new FlowLayout());

        // 布局
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        // 添加监听器
        button.addActionListener(new MyMonitor2());

        pack();
        setVisible(true);
    }

    public Calculator() {
    }

    private class MyMonitor2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            num3.setText("" + (n1 + n2));
        }
    }
}

