package com.base.collectionframework.mapImp.map;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @ClassName MapTestDemo
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/31 19:29
 */
/*
Map集合的案例-统计投票人数
需求
● 某个班级80名学生，现在需要组织秋游活动，班长提供了四个景点依次是（A、B、C、D），每个学
  生只能选择一个景点，请统计出最终哪个景点想去的人数最多。

分析
● 将80个学生选择的数据拿到程序中去，[A,A,B，A,B，C,D，.]
● 准备一个Map集合用于存储统计的结果，Map<String，Integer>，键是景点，值代表投票数量。
● 遍历80个学生选择的景点，每遍历一个景点，就看Map集合中是否存在该景点，不存在存入“景点=1
  存在则其对应值+1
 */
public class MapTestDemo {
    public static void main(String[] args) {
        // 1. 存放80个景点
        List<String> list = new ArrayList<>();
        String[] letter = {"A", "B", "C", "D"}; // 存放四个景点
        Random r = new Random();
        for (int i = 1; i <= 80; i++) {
            int index = r.nextInt(4);
            list.add(letter[index]);
        }
        System.out.println(list);
        System.out.println(list.size());

        // 2. 统计数据
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        System.out.println(map);
        map.forEach((s, integer) -> System.out.println(s + ":" + integer));

    }
}
