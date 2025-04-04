package com.base.io.io.object_flow;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @ClassName Test3ArrayListSerializable
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/4 17:10
 */
public class Test4InArrayListSerializable {
    public static void main(String[] args) {
        try (
                ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("base/src/com/base/io/io/object_flow/testPersonOut.txt")));
                ) {
            ArrayList<Person> persons = (ArrayList<Person>) ois.readObject();
//            persons.forEach(System.out::println);
            persons.forEach((s) -> System.out.println(s.toString()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
