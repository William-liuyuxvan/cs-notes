package com.base.io.file.demo3;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/2 20:49
 */
public class Application {
    public static void main(String[] args) {
        File f1 = new File("E:\\notes\\狂神说java\\project\\base\\src\\com\\base");
        Arrays.stream(Objects.requireNonNull(f1.list())).forEach(System.out::println);
    }
}
