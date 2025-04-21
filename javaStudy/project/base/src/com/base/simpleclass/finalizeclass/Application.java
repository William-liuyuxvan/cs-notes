package com.base.simpleclass.finalizeclass;

/**
 * @ClassName finalizeclass
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/27 16:31
 */
public class Application {
    public static void main(String[] args) {
        new Student(1, "xiaohong", 18);
        new Student(2, "xiaoming", 20);
        new Student(3, "xiaozhang", 30);
        new Student(4, "xiaozhao", 11);

        System.gc();
        System.out.println("回收垃圾成功。");
    }
}
