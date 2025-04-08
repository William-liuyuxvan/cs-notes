package com.base.gui.three;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName TestMouse
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/8 12:11
 */
// 通过监听鼠标进行画图
public class TestMouse {
    public static void main(String[] args) {
        new MyMouse("MousePaint").loadFrame();
    }
}

class MyMouse extends Frame {

    private ArrayList list = new ArrayList();

    public MyMouse(String title) {
        super(title);
    }

    public void loadFrame() {
        setBounds(200, 200, 600 ,500);
        setVisible(true);
        addMouseListener(new MyMouseMonitor());
        addWindowListener(new MyMonitor());
    }

    @Override
    public void paint(Graphics g) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Point p = (Point) iterator.next();
            g.fillOval(p.x, p.y, 10, 10);
        }
    }

    private class MyMouseMonitor extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            list.add(new Point(e.getX(), e.getY()));
            repaint();
        }
    }

    private static class MyMonitor extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
