package com.base.io.file.demo1;

import java.io.File;

/**
 * @ClassName application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/2 20:23
 */
public class application {
    public static void main(String[] args) {
        // 文件分隔符
//        File file = new File("E:\\compileCourse\\CompileFX\\test\\词法分析用例1.txt");
//        File file = new File("E:/compileCourse/CompileFX/test/词法分析用例1.txt");
        File file = new File("E:" + File.separator + "compileCourse" + File.separator + "CompileFX" + File.separator + "test" + File.separator + "词法分析用例1.txt");
        System.out.println(file.length()); // 打印字节数
    }
}
