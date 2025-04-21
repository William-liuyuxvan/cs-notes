package com.base.io.io.data_flow;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/4 16:34
 */
public class Demo1 {
    public static void main(String[] args) {
        try (
                DataOutputStream dos = new DataOutputStream(Files.newOutputStream(Paths.get("base\\src\\com\\base\\io\\io\\data_flow\\test.txt")));
                ) {
            dos.writeByte(97);
            dos.writeInt(1111);
            dos.writeDouble(1.11);
            dos.writeUTF("撒地方撒地方");

            dos.write(79);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
