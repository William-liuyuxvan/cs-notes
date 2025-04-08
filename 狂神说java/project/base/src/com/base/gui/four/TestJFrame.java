package com.base.gui.four;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName TestJFrame
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/8 14:44
 */
public class TestJFrame {
    public static void main(String[] args) {
        new MyJFrame().init();
    }
}

class MyJFrame extends JFrame {

    public void init() {
        setBounds(100, 100, 450, 300);
        setVisible(true);

        // 添加一个标签并且居中
        JLabel jLabel = new JLabel("hello world!");
        add(jLabel);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 设置容器
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.yellow);
    }
}
