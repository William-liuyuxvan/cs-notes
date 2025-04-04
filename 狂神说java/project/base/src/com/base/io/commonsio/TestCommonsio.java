package com.base.io.commonsio;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName TestCommonsio
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/4 17:49
 */
public class TestCommonsio {
    public static void main(String[] args) throws Exception {
//        FileUtils.copyFile(new File("base\\src\\com\\base\\io\\test.txt"), new File("base\\src\\com\\base\\io\\commonsio\\a.txt"));
//        FileUtils.delete(new File("base\\src\\com\\base\\io\\commonsio\\a.txt"));
//        String str = FileUtils.readFileToString(new File("base\\src\\com\\base\\io\\commonsio\\a.txt"));
//        System.out.println(str);

        Files.copy(Paths.get("base\\src\\com\\base\\io\\test.txt"), Paths.get("base\\src\\com\\base\\io\\commonsio\\b.txt"));

    }
}
