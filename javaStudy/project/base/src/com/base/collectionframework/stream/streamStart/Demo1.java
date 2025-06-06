package com.base.collectionframework.stream.streamStart;

import java.util.*;
import java.util.stream.Stream;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/31 20:38
 */
public class Demo1 {
    public static void main(String[] args) {
        //1、如何获取List集合的Stream流？
        System.out.println("1、如何获取List集合的Stream流？");
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"张三丰", "张无忌", "周芷若", "赵敏", "张强");
        names.stream().filter(name -> name.contains("张")).forEach(System.out::println);

        //2、如何获取Set集合的Stream流？
        System.out.println("2、如何获取Set集合的Stream流？");
        Set<String> set=new HashSet<>();
        Collections.addAll(set,"刘德华", "张曼玉", "蜘蛛精", "马德", "德玛西亚");
        set.stream().filter(s -> s.contains("德")).forEach(System.out::println);

        //3、如何获取Map集合的Stream流？
        System.out.println("3、如何获取Map集合的Stream流？");
        Map<String,Double>map=new HashMap<>();
        map.put("古力娜扎", 172.3);
        map.put("迪丽热巴", 168.3);
        map.put("马尔扎哈", 166.3);
        map.put("卡尔扎巴", 168.3);

        map.entrySet().stream().filter(entry -> entry.getKey().contains("扎")).forEach(entry -> System.out.println(entry.getKey() + "--->"+ entry.getValue()));

        //4、如何获取数组的Stream流？
        System.out.println("4、如何获取数组的Stream流？");
        String[] names2={"张翠山", "东方不败", "唐大山", "独孤求败"};

        // 方法1：使用Arrays中的stream()方法
        System.out.println("方法1：使用Arrays中的stream()方法");
        Arrays.stream(names2).filter(str -> str.contains("山")).forEach(System.out::println);

        // 方法2：使用Stream中静态方法of()
        System.out.println("方法2：使用Stream中静态方法of()");
        Stream.of(names2).filter(str -> str.contains("山")).forEach(System.out::println);

    }
}
