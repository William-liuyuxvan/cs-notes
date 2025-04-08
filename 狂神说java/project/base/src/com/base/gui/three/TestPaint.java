package com.base.gui.three;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName TestPaint
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/8 11:27
 */
public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame {
    public void loadFrame() {
        setVisible(true);
        setBounds(200, 200, 600, 500);
        addWindowListener(new MyMonitor());
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(50, 50, 40, 100);
    }

    private static class MyMonitor extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}