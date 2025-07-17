package com.yuxuan.test.nio.c1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName TestScatteringReads
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/27 19:54
 */
public class TestScatteringReads {

    public static void main(String[] args) {
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("world");
        ByteBuffer buffer3 = StandardCharsets.UTF_8.encode("你好");

        try (FileChannel fileChannel = new RandomAccessFile("word.txt", "rw").getChannel()) {
            fileChannel.write(new ByteBuffer[]{buffer1, buffer2, buffer3});
        } catch (IOException e) {
        }

    }

}
