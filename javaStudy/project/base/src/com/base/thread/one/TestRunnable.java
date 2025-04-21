package com.base.thread.one;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @ClassName TestRunnable
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 10:06
 */
public class TestRunnable implements Runnable{

    private String url;
    private String fileName;

    public TestRunnable(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
            WebDownloader.downloadFromURLToFile(url, fileName);
    }

    public static void main(String[] args) {
        new Thread(new TestRunnable("https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/34905050930/6160/8991/0f0f/85d4094a013dc7c0709fd198152ee9f7.png", "base/src/com/base/thread/one/7.png")).start();
    }
}

class WebDownloader {

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