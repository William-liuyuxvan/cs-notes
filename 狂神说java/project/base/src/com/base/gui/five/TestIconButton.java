package com.base.gui.five;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @ClassName TestIconButton
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/9 14:38
 */
public class TestIconButton extends JFrame {

    public TestIconButton() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        URL url = TestIconButton.class.getResource("image.jpg");
        ImageIcon icon = new ImageIcon(url);

        JButton button = new JButton(icon);
        button.setToolTipText("imageicon");

        getContentPane().add(button);
    }

    public static void main(String[] args) {
        new TestIconButton();
    }

    /**
     * @ClassName TestIconButton
     * @Description TODO
     * @Author eeekuu
     * @Date 2025/4/9 14:38
     */
    public static class TestJCheckBox extends JFrame {

        public TestJCheckBox() {
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);

            JCheckBox checkBox1 = new JCheckBox("多选1");
            JCheckBox checkBox2 = new JCheckBox("多选2");
            JCheckBox checkBox3 = new JCheckBox("多选3");

            getContentPane().setLayout(new FlowLayout());
            getContentPane().add(checkBox1);
            getContentPane().add(checkBox2);
            getContentPane().add(checkBox3);
        }

        public static void main(String[] args) {
            new TestJCheckBox();
        }
    }

    /**
     * @ClassName TestIconButton
     * @Description TODO
     * @Author eeekuu
     * @Date 2025/4/9 14:38
     */
    public static class TestJRadioButton extends JFrame {

        public TestJRadioButton() {
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);

            JRadioButton button1 = new JRadioButton("btn1");
            JRadioButton button2 = new JRadioButton("btn2");
            JRadioButton button3 = new JRadioButton("btn3");

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(button1);
            buttonGroup.add(button2);
            buttonGroup.add(button3);

            getContentPane().add(button1, BorderLayout.NORTH);
            getContentPane().add(button2, BorderLayout.CENTER);
            getContentPane().add(button3, BorderLayout.SOUTH);
        }

        public static void main(String[] args) {
            new TestJRadioButton();
        }
    }
}
