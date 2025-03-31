package com.base.collectionframework.mapImp.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @ClassName Main
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/31 19:10
 */
public class LambdaTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);

//        map.forEach((s, integer) -> System.out.println(s+":"+integer));
        map.forEach((s, integer) -> System.out.println(s+":"+integer));
    }
}
