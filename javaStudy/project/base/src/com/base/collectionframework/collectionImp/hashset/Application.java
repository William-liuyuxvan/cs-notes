package com.base.collectionframework.collectionImp.hashset;

import com.base.oop.Demo1.Person;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/30 17:24
 */
public class Application {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = "abc";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());

        Student s1 = new Student();
        Person p1 = new Student();
        Person p2 = new Person();
        System.out.println(p1 instanceof Student);
        System.out.println(p2 instanceof Student);
        System.out.println(s1.getClass());
        System.out.println(p1.getClass());

        TreeSet<Student> set = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge());
        TreeSet<Student> set1 = new TreeSet<>(Comparator.comparingInt(Student::getAge));
    }
}
