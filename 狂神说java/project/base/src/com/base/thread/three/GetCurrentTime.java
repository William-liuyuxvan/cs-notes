package com.base.thread.three;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName GetCurrentTime
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 15:24
 */

// 获取当前时间，倒计时
public class GetCurrentTime {

    public static void main(String[] args) throws InterruptedException {

        // 一 十秒钟倒计时
        tenDown();

        // 二 获取当前时间
        Date date = null;
        int count = 10;
        while (count-- > 0) {
            date = new Date(System.currentTimeMillis());
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            Thread.sleep(1000);
        }
    }

    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (num-- > 0) {
            System.out.println(num);
            Thread.sleep(1000);
        }
    }
}
