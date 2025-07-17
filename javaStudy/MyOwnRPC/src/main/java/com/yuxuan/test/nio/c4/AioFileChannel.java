package com.yuxuan.test.nio.c4;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.yuxuan.test.nio.c1.ByteBufferUtil.debugAll;

/**
 * @ClassName AioFileChannel
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/29 16:11
 */
@Slf4j
public class AioFileChannel {
    public static void main(String[] args) {
        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("data.txt"), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(16);
            log.info("before read...");
            channel.read(buffer, 0, buffer, new CompletionHandler<>() {
                @Override // 成功返回
                public void completed(Integer result, ByteBuffer attachment) {
                    log.info("reading...{}", result);
                    attachment.flip();
                    debugAll(attachment);
                }
                @Override // 失败返回
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                }
            });
            log.info("after read...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
