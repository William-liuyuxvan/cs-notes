package com.base.io.io.conversion_flow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/4 12:21
 */
public class Demo1 {
    public static void main(String[] args) {
        try (
                FileInputStream is = new FileInputStream("base/src/com/base/io/io/conversion_flow/test.txt");
                Reader isr = new InputStreamReader(is, "GBK");
                BufferedReader br = new BufferedReader(isr);
        ) {
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println("读取完成！");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
