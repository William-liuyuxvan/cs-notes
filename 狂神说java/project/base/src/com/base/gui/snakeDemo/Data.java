package com.base.gui.snakeDemo;

import javax.swing.*;
import java.net.URL;

/**
 * @ClassName Data
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/9 16:51
 */
public class Data {
    private static URL headerURL = Data.class.getResource("statics/header.png");
    public static ImageIcon header = new ImageIcon(headerURL);

    private static URL upURL = Data.class.getResource("statics/up.png");
    private static URL downURL = Data.class.getResource("statics/down.png");
    private static URL leftURL = Data.class.getResource("statics/left.png");
    private static URL rightURL = Data.class.getResource("statics/right.png");
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);

    private static URL foodURL = Data.class.getResource("statics/food.png");
    public static ImageIcon food = new ImageIcon(foodURL);

    private static URL bodyURL = Data.class.getResource("statics/body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);
}
