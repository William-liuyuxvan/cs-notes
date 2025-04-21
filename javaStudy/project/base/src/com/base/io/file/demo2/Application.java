package com.base.io.file.demo2;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/2 20:37
 */
public class Application {
    public static void main(String[] args) {
        File file = new File("E:\\compileCourse\\CompileFX\\test\\词法分析用例1.txt");
        long l = file.lastModified();
//        System.out.println(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(l));

    }
}
