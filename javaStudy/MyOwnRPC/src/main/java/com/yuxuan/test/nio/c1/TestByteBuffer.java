package com.yuxuan.test.nio.c1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName TestBuffer
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/27 14:04
 */
public class TestByteBuffer {

    public static void main(String[] args) {
        // fileChannel
        // 获取：1. 输入输出流  2. RandomAccessFile

        try (FileInputStream fileInputStream = new FileInputStream("data.txt");
                FileChannel channel = fileInputStream.getChannel()) {
            // 准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
                // 从 channel 中读取数据，向 byteBuffer 中写入
                int len = channel.read(buffer);
                if (len == -1) { // 没有内容了
                    break;
                }
                // 打印 byteBuffer 中的内容
                buffer.flip(); // 切换至读模式
                while (buffer.hasRemaining()) { // 是否还有剩余未读数据
                    byte b = buffer.get();
                    System.out.println((char) b);
                }
                buffer.clear(); // 切换为写模式
            }
        } catch (IOException e) {
        }
    }

}
