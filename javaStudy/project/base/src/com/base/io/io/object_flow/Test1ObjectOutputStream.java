package com.base.io.io.object_flow;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName Test1ObjectOutputStream
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/4 16:54
 */
public class Test1ObjectOutputStream {
    public static void main(String[] args) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("base/src/com/base/io/io/object_flow/testOut.txt")));
                ) {
            User user = new User("admin", "张三", 19, "123123");
            oos.writeObject(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
