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
        new Calculator();
    }
}

class Calculator extends Frame {
    public Calculator() {
        setTitle("Calculator");

        // 三个文本框
        TextField textField1 = new TextField(10);
        TextField textField2 = new TextField(10);
        TextField textField3 = new TextField(20);

        // 一个label +
        Label label = new Label("+");

        // 一个按钮 =
        Button button = new Button("=");

        // 流式添加到frame中
        setLayout(new FlowLayout());
        add(textField1);
        add(label);
        add(textField2);
        add(button);
        add(textField3);

        // 添加监听器
        button.addActionListener(new MyMonitor2(textField1, textField2, textField3));

        pack();
        setVisible(true);
    }
}

class MyMonitor2 implements ActionListener {

    TextField num1;
    TextField num2;
    TextField num3;

    public MyMonitor2(TextField num1, TextField num2, TextField num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n1 = Integer.parseInt(num1.getText());
        int n2 = Integer.parseInt(num2.getText());
        num3.setText("" + (n1 + n2));
    }
}