package com.base.reflection.one;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @ClassName Test08
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 21:38
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Student.class;

        System.out.println(c1); // class com.base.reflection.one.Student

        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        /*
            @com.base.reflection.one.TableLiu(value=db_student)
         */

        // 获取annotation中的值
        TableLiu tableLiu = (TableLiu) c1.getAnnotation(TableLiu.class);
        System.out.println(tableLiu.value()); // db_student

        // 获取属性中的注解信息
        Field id = c1.getDeclaredField("id");
        System.out.println(id); // private int com.base.reflection.one.Student.id
        FieldLiu fieldLiu = id.getAnnotation(FieldLiu.class);
        System.out.println(fieldLiu.columnName()); // db_id
        System.out.println(fieldLiu.type()); // int
        System.out.println(fieldLiu.length()); // 10

    }
}

@TableLiu("db_student")
class Student {
    @FieldLiu(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldLiu(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FieldLiu(columnName = "db_name", type = "varchar", length = 5)
    private String name;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableLiu {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldLiu {
    String columnName();
    String type();
    int length();
}
