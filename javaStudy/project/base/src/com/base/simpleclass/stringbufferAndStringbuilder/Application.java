package com.base.simpleclass.stringbufferAndStringbuilder;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/28 14:36
 */
public class Application {
    public static void main(String[] args) {
        String str = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            str = str + i;
        }
        long end = System.currentTimeMillis();
        System.out.println("String: " + (end - start));

        StringBuffer sb = new StringBuffer();
        start = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            sb.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (end - start));

        StringBuilder sb2 = new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            sb2.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (end - start));
    }
}
