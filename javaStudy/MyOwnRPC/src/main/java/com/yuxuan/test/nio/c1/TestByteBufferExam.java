package com.yuxuan.test.nio.c1;

import java.nio.ByteBuffer;

import static com.yuxuan.test.nio.c1.ByteBufferUtil.debugAll;

/**
 * @ClassName TestByteBufferExam
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/27 20:13
 */
public class TestByteBufferExam {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put("Hello,word\nI'm zhangsan\nHo".getBytes());
        split(buffer);
        buffer.put("w are you?\n".getBytes());
        split(buffer);
    }

    public static void split(ByteBuffer source) {
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int len = i + 1 - source.position();
                ByteBuffer allocate = ByteBuffer.allocate(len);
                for (int j = 0; j < len; j++) {
                    allocate.put(source.get());
                }
                debugAll(allocate);
            }
        }
        source.compact();
    }

}
