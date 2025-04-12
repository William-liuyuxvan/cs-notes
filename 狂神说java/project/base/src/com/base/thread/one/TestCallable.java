package com.base.thread.one;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @ClassName TestCallable
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 11:27
 */
public class TestCallable implements Callable<Boolean> {


    private String url;
    private String fileName;

    public TestCallable(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public Boolean call() {
        WebDownloader2.downloadFromURLToFile(url, fileName);
        System.out.println("下载完成：" + fileName);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/34905050930/6160/8991/0f0f/85d4094a013dc7c0709fd198152ee9f7.png", "base/src/com/base/thread/one/1.png");
        TestCallable t2 = new TestCallable("https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/34905050930/6160/8991/0f0f/85d4094a013dc7c0709fd198152ee9f7.png", "base/src/com/base/thread/one/2.png");
        TestCallable t3 = new TestCallable("https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/34905050930/6160/8991/0f0f/85d4094a013dc7c0709fd198152ee9f7.png", "base/src/com/base/thread/one/3.png");

        // 1. 创建执行服务
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 2. 提交执行
        Future<Boolean> submit1 = pool.submit(t1);
        Future<Boolean> submit2 = pool.submit(t2);
        Future<Boolean> submit3 = pool.submit(t3);

        // 3. 获取结果
        boolean b1 = submit1.get();
        boolean b2 = submit2.get();
        boolean b3 = submit3.get();

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        // 4. 关闭服务
        pool.shutdownNow();
    }
}

class WebDownloader2 {

    public static void downloadFromURLToFile(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
            System.out.println(new File(fileName).getAbsolutePath());
            System.out.println("SUCCESS");
        } catch (IOException e) {
            System.out.println("FAILURE");
            throw new RuntimeException(e);
        }
    }
}