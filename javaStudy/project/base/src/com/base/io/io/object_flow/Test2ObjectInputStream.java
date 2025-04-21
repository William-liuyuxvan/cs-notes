package com.base.io.io.object_flow;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName Test2ObjectInputStream
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/4 17:00
 */
public class Test2ObjectInputStream {
    public static void main(String[] args) {
        try (
                ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("base/src/com/base/io/io/object_flow/testOut.txt")))
                    ) {
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }
}
