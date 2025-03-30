package com.base.collectionframework.collectionImp.hashset;

import com.base.oop.Demo1.Person;

import java.util.Objects;

/**
 * @ClassName Student
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/30 17:33
 */
public class Student extends Person implements Comparable {
    private String name;
    private int age;
    private int sex;

    public Student() {
    }

    public Student(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return age == student.age && sex == student.sex && Objects.equals(name, student.name);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age && sex == student.sex && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.age - ((Student) o).age == 0 ? this.name.compareTo(((Student) o).name) : this.age - ((Student) o).age;
    }
}
