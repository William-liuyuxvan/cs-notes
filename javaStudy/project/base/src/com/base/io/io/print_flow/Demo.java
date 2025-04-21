package com.base.io.io.print_flow;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.security.spec.ECField;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/4 15:37
 */
public class Demo {
    public static void main(String[] args) {
        try (
                PrintStream out = new PrintStream(new FileOutputStream("base/src/com/base/io/io/print_flow/out.txt", true));
                ) {
            System.setOut(out);
            System.out.println("hello printstream!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
