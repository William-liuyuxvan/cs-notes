package com.base.io.io.data_flow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/4 16:34
 */
public class Demo2 {
    public static void main(String[] args) {
        try (
                DataInputStream dis = new DataInputStream(Files.newInputStream(Paths.get("base\\src\\com\\base\\io\\io\\data_flow\\test.txt")));
                PrintStream ps = new PrintStream("base\\src\\com\\base\\io\\io\\data_flow\\printTest.txt");
                ) {
            System.setOut(ps);
            System.out.println(dis.readByte());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());

            System.out.println(dis.read());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
