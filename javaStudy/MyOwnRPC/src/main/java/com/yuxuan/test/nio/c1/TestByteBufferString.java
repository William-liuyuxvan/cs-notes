package com.yuxuan.test.nio.c1;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

import static com.yuxuan.test.nio.c1.ByteBufferUtil.debugAll;

/**
 * @ClassName TestByteBufferString
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/27 17:58
 */
public class TestByteBufferString {

    public static void main(String[] args) {
        // 1. 字符串转为 ByteBuffer
        ByteBuffer buffer1 = ByteBuffer.allocate(16);
        buffer1.put("hello".getBytes());
        debugAll(buffer1);

        // 2. Charset
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("hello");
        debugAll(buffer2);

        // 3. wrap
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes());
        debugAll(buffer3);

        // 4. 转为字符串
        CharBuffer decode1 = StandardCharsets.UTF_8.decode(buffer3);
        System.out.println(decode1);

        buffer1.flip();
        CharBuffer decode2 = StandardCharsets.UTF_8.decode(buffer1);
        System.out.println(decode2);
    }

}
