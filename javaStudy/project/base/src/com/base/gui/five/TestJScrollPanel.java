package com.base.gui.five;

import javax.swing.*;

/**
 * @ClassName TestJScrollPanel
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/8 17:45
 */
public class TestJScrollPanel extends JFrame {

    public TestJScrollPanel() {
        // 基本设置
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        // 添加文本域到滚动面板中
        JScrollPane scrollPane = new JScrollPane(new JTextArea("欢迎来到这大千世界！", 10,20));

        // 将面板添加到容器中
        getContentPane().add(scrollPane);
    }

    public static void main(String[] args) {
        new TestJScrollPanel();
    }
}
