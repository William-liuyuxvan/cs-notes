package com.base.io.io.object_flow;

import java.io.IOException;
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
public class Test3OutArrayListSerializable {
    public static void main(String[] args) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("base/src/com/base/io/io/object_flow/testPersonOut.txt")));
                ) {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person("张三", 3));
            persons.add(new Person("张三", 3));
            persons.add(new Person("张三", 3));
            persons.add(new Person("张三", 3));

            oos.writeObject(persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
