package com.base.jvm;

/**
 * @ClassName TestGCDetails
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/14 21:21
 */
public class TestGCDetails {

    public static void main(String[] args) {
        // 打印理想化最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("打印理想化最大内存: " + maxMemory + " = " +  (maxMemory / (double) 1024 / 1024) + "m");

        // 打印实际总内存
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("打印理想化最大内存: " + totalMemory + " = " +  (totalMemory / (double) 1024 / 1024) + "m");

        // 大约
        // 理想化最大内存 : 系统内存 == 1 : 4
        // 实际总内存 : 系统内存 == 1 : 64


        // -Xms1024m -Xmx1024m -XX:+PrintGCDetails
    }
}
