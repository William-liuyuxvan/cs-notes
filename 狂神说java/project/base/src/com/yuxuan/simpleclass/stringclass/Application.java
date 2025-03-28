package com.yuxuan.simpleclass.stringclass;

import java.util.Arrays;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/28 14:10
 */
public class Application {
    public static void main(String[] args) {
        String str = "my name is william";

        System.out.println(str.substring(0, str.length()));

        // 在 public String[] split(String str); 方法中可以使用正则表达式
        String say = "java is the best    programing language, java xiang";
        // 利用split方法分为每个单词
        String[] arr = say.split(" ");
        System.out.println(Arrays.toString(arr)); // [java, is, the, best, , , , programing, language,, java, xiang]

        String[] arr2 = say.split("[ ,]"); // [ ,] 表示在" "或","分开
        System.out.println(Arrays.toString(arr2)); // [java, is, the, best, , , , programing, language, , java, xiang]

        String[] arr3 = say.split("[ ,]+"); // [ ,]+ 表示在所有" "或","分开
        System.out.println(Arrays.toString(arr3)); // [java, is, the, best, programing, language, java, xiang]

    }
}
