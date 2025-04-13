package com.base.thread.six;

import java.util.concurrent.*;

/**
 * @ClassName TestThreadPoll
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 14:14
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " 执行");
            });
        }

        executorService.shutdown();
    }
}
