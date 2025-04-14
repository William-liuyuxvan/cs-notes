package com.base.jvm;

/**
 * @ClassName TestOOM
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/14 21:33
 */
// -Xms1024m -Xmx1024m -XX:+PrintGCDetails
public class TestOOM {

    public static void main(String[] args) {
        String str = "--";

        while (true) {
            str += str; // java.lang.OutOfMemoryError: Java heap space
        }
    }
}
