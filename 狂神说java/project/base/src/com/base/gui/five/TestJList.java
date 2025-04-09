package com.base.gui.five;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * @ClassName TestJList
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/9 15:11
 */
public class TestJList extends JFrame {

    public TestJList() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        Container container = getContentPane();

        Vector vector = new Vector();
        JList list = new JList(vector);
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        container.add(scrollPane);

        vector.add("1");
        vector.add("1");
        vector.add("1");
    }

    public static void main(String[] args) {
        new TestJList();
    }
}
