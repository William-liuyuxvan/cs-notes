package com.base.collectionframework.stream.streamEnd;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/1 9:51
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student s1=new Student("蜘蛛精", 26, 172.5);
        Student s2=new Student("蜘蛛精", 26, 172.5);
        Student s3=new Student("紫霞", 23, 167.6);
        Student s4=new Student("白晶晶", 25, 169.0);
        Student s5=new Student("牛庵王", 35, 183.3);
        Student s6=new Student("牛夫人", 34, 168.5);
        Collections.addAll(students, s1, s2, s3,s4, s5, s6);
        //需求1：请计算出身高超过168的学生有几人。
        System.out.println("需求1：请计算出身高超过168的学生有几人。");
        long count = students.stream().filter(s -> s.getHeight() > 168).count();
        System.out.println(count);

        //需求2：请找出身高最高的学生对象，并输出。
        System.out.println("需求2：请找出身高最高的学生对象，并输出。");
        Student student1 = students.stream().max((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight())).get();
        System.out.println(student1);

        //需求3：请找出身高最矮的学生对象，并输出。
        System.out.println("需求3：请找出身高最矮的学生对象，并输出。");
        Student student2 = students.stream().min((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight())).get();
        System.out.println(student2);

        //需求4：请找出身高超过170的学生对象，并放到一个新集合中去返回。
        System.out.println("需求4：请找出身高超过170的学生对象，并放到一个新集合中去返回。");
        System.out.println("list:");
        List<Student> collect1 = students.stream().filter(s -> s.getHeight() > 170).collect(Collectors.toList());
        System.out.println(collect1);

        System.out.println("set:");
        Set<Student> collect2 = students.stream().filter(s -> s.getHeight() > 170).collect(Collectors.toSet());
        System.out.println(collect2);

        //需求5：请找出身高超过170的学生对象，并把学生对象的名字和身高，存入到一个Map集合返回。
        System.out.println("需求5：请找出身高超过170的学生对象，并把学生对象的名字和身高，存入到一个Map集合返回。");
        // 方法1：利用collect()
        System.out.println("方法1：利用collect()");
        Map<String, Double> map = students.stream().filter(s -> s.getHeight() > 170).distinct().collect(Collectors.toMap(Student::getName, Student::getHeight)); // toMap()不能自动过滤相同key值元素，需要手动加入distinct()来过滤
        System.out.println(map);

        // 方法2：利用toArray()
        System.out.println("方法2：利用toArray()");
        Object[] array = students.stream().filter(s -> s.getHeight() > 170).toArray();
        System.out.println(Arrays.toString(array));
    }
}
