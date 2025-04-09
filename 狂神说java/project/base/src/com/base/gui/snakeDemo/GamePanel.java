package com.base.gui.snakeDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @ClassName GamePanel
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/9 16:45
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {

    // 蛇的数据结构
    private int length; // 蛇的长度
    private int[] snakeX = new int[600]; // 蛇的x坐标
    private int[] snakeY = new int[500]; // 蛇的y坐标

    // 蛇的方向
    private int snakeDirection;
    private final int SNAKE_UP = 1;
    private final int SNAKE_RIGHT = 2;
    private final int SNAKE_DOWN = 3;
    private final int SNAKE_LEFT = 4;

    // 食物的坐标
    private int foodX;
    private int foodY;
    private Random rand = new Random(); // 随机数食物坐标

    // 分数
    private int score;

    // 游戏暂停状态
    private boolean isStart;

    // 游戏失败状态
    private boolean isFail;

    // 计时器
    private final Timer timer = new Timer(100, this); // 100毫秒执行一次

    public GamePanel() {
        init();
        // 添加焦点
        setFocusable(true);
        // 添加键盘监听事件
        addKeyListener(this);
    }

    private void init() {
        // 初始化小蛇
        length = 3;
        // 头部
        snakeX[0] = 100;
        snakeY[0] = 100;
        // 身体
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
        // 方向
        snakeDirection = SNAKE_RIGHT;

        // 食物坐标初始化
        foodInit();

        // 分数初始化
        score = 0;

        // 游戏状态
        isStart = false;
        // 失败状态
        isFail = false;

        // 打开定时器
        timer.start();
    }

    private void foodInit() {
        foodX = 25 + 25 * rand.nextInt(34);
        foodY = 75 + 25 * rand.nextInt(24);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // 清屏
        this.setBackground(Color.WHITE);

        Data.header.paintIcon(this, g, 25, 11);
        g.setColor(new Color(38, 38, 38));
        g.fillRect(25, 75, 850, 600);

        // 画长度和食物
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));
        g.drawString("Length: " + length, 750, 50);
        g.drawString("Score: " + score, 750, 32);

        // 画食物
        Data.food.paintIcon(this, g, foodX, foodY);

        // 画蛇
        // 蛇头的方向
        if (snakeDirection == SNAKE_UP) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (snakeDirection == SNAKE_DOWN) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (snakeDirection == SNAKE_LEFT) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (snakeDirection == SNAKE_RIGHT) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        // 蛇身方向
        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        // 暂停提示
        if (!isStart) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Times New Roman", Font.BOLD, 40));
            g.drawString("Press Space to start the game", 200, 360);
        }

        // 失败提示
        if (isFail) {
            g.setColor(Color.RED);
            g.setFont(new Font("Times New Roman", Font.BOLD, 40));
            g.drawString("  You have lost the game \n Press Space to restart the game", 100, 340);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_SPACE) {
            if (isFail) {
                // 重新开始
                init();
            } else {
                isStart = !isStart;
            }
        } else if (isStart && !isFail) {
            if (code == KeyEvent.VK_UP) {
                snakeDirection = SNAKE_UP;
            } else if (code == KeyEvent.VK_RIGHT) {
                snakeDirection = SNAKE_RIGHT;
            } else if (code == KeyEvent.VK_DOWN) {
                snakeDirection = SNAKE_DOWN;
            } else if (code == KeyEvent.VK_LEFT) {
                snakeDirection = SNAKE_LEFT;
            }
        }

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && !isFail) {
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                foodInit();
                length++;
                score += 10;
            }

            for (int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            if (snakeDirection == SNAKE_UP) {
                // 上移
                snakeY[0] -= 25;
                if (snakeY[0] < 75) {snakeY[0] = 650;}
            } else if (snakeDirection == SNAKE_RIGHT) {
                // 右移
                snakeX[0] += 25;
                if (snakeX[0] > 850) {snakeX[0] = 25;}
            } else if (snakeDirection == SNAKE_DOWN) {
                // 下移
                snakeY[0] += 25;
                if (snakeY[0] > 650) {snakeY[0] = 75;}
            } else if (snakeDirection == SNAKE_LEFT) {
                // 左移
                snakeX[0] -= 25;
                if (snakeX[0] < 25) {snakeX[0] = 850;}
            }

            for (int i = 1; i < length; i++) {
                if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
                    isFail = true;
                    break;
                }
            }

            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
