package com.base.collectionframework.collectionImp.collection;

import java.util.*;

/**
 * @ClassName Applicatioin
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/29 11:23
 */
public class Applicatioin {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");
        System.out.println(c);

        // 迭代器遍历
        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // lambda
        c.forEach(s -> {
            System.out.println(s);
        });

        // 测试movie
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("《肖生克的救赎》", 9.7,"罗宾斯"));
        movies.add(new Movie("《霸王别姬》", 9.6,"张国荣、张丰毅"));
        movies.add(new Movie("《阿甘正传》", 9.5,"汤姆·汉克斯"));

        // 迭代器
        System.out.println("1.迭代器");
        Iterator<Movie> it = movies.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 增强for
        System.out.println("2.增强for");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        // lambda
        System.out.println("3.lambda");
        movies.forEach(System.out::println);
    }
}
