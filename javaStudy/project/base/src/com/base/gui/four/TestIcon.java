package com.base.gui.four;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName TestIcon
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/8 16:49
 */
public class TestIcon extends JFrame implements Icon {

    private int width;
    private int height;

    public TestIcon() {}

    public TestIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() {
        TestIcon icon = new TestIcon(15, 15);
        Container contentPane = getContentPane();
        contentPane.add(new JLabel("icon", icon, SwingConstants.CENTER));

        setBounds(100, 100, 600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestIcon().init();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return this.getWidth();
    }

    @Override
    public int getIconHeight() {
        return this.getHeight();
    }
}
