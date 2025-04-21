package com.base.io.recursion;

import java.io.File;

/**
 * @ClassName demo2
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/3 16:33
 */
public class Demo2 {
    public static void main(String[] args) {
        searchFile(new File("E:\\notes\\狂神说java\\java常用类、集合、IO"), "javaIO流.md");
    }

    public static void searchFile(File dir, String fileName) {
        // 1.将非法dir拦截
        if (dir == null || fileName == null || !dir.exists() || dir.isFile()) {return;}

        // 2.dir肯定是路径
        // 获取一级目录
        File[] files = dir.listFiles();

        // 3.判断以及一级文件目录不是null，并且不为空
        if (files != null && files.length > 0) {
            // 4.遍历一级文件目录
            for (File f : files) {
                // 5.如果是文件，则判断是否是目标文件
                if (f.isFile() && f.getName().equals(fileName)) {
                    System.out.println(f.getAbsolutePath());
                    return;
                } else if (f.isDirectory()) {
                    searchFile(f, fileName);
                }
            }
        }
    }
}
