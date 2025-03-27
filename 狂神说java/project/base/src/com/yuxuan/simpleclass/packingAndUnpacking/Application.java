package com.yuxuan.simpleclass.packingAndUnpacking;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/27 16:56
 */
public class Application {
    public static void main(String[] args) {
        int testNum = 10;
        // JDK1.5之前，“手动”装箱、拆箱
        // 装箱
        // 方法1
        Integer integer1 = new Integer(testNum);
        // 方法2
        Integer integer2 = Integer.valueOf(testNum);
        // 拆箱
        int num1 = integer1.intValue();

        // JDK1.5之后，“自动”装箱、拆箱
        // 自动装箱
        Integer integer3 = testNum;
        // 自动拆箱
        int num2 = integer3;

        Integer
    }
}
