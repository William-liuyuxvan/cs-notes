package com.yuxuan.test.nio.c1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @ClassName TestFileChannelTransferTo
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/27 20:31
 */
public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try (
                FileChannel from = new FileInputStream("data.txt").getChannel();
                FileChannel to = new FileOutputStream("to.txt").getChannel();
        ) {
            long size = from.size();
            for (long left = size; left > 0;) {
                System.out.println("position: " + (size - left) + " left: " + left);
                left -= from.transferTo(size - left, left, to);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (
//                FileChannel from = new FileInputStream("data.txt").getChannel();
//                FileChannel to = new FileOutputStream("to1.txt").getChannel();
//        ) {
//            to.transferFrom(from, 0, from.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
