package com.base.collectionframework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName CollectionConcurrentModificationException
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/30 20:18
 */
public class CollectionConcurrentModificationException {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("王麻子");
        list.add("小李子");
        list.add("李爱花");
        list.add("张全蛋");
        list.add("小李");
        list.add("李玉刚");
        System.out.println(list);


        // --------------错误写法---------------------
        // 错误方法1：使用普通for循环删除 --- 删除了数据之后，数组后面的数据向前移，导致有些数据无法识别
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).contains("李")) {
//                list.remove(i);
//            }
//        }
//        System.out.println(list); // [王麻子, 李爱花, 张全蛋, 李玉刚]

        // 错误方法2：使用迭代器 ---- ConcurrentModificationException
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            String name = it.next();
//            if (name.contains("李")) {
//                list.remove(name);
//            }
//        }
//        System.out.println(list);

        // --------------正确写法---------------------
        // 正确方法1：普通for 删除后--
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).contains("李")) {
//                list.remove(i);
//                i--;
//            }
//        }
//        System.out.println(list);


        // 正确方法2：普通for 倒着删除
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).contains("李")) {
                list.remove(i);
            }
        }
        System.out.println(list);

        // 正确方法3：利用迭代器中的remove()方法 --- 在remove()方法中也进行了i--操作
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            String name = it.next();
//            if (name.contains("李")) {
//                it.remove();
//            }
//        }
//        System.out.println(list);

        // --------------无法修改的错误写法---------------------
        // 无法原谅方法1：增强for (简化版迭代器) ------ ConcurrentModificationException
//        for (String name : list) {
//            if (name.contains("李")) {
//                list.remove(name);
//            }
//        }
//        System.out.println(list);

        // 无法原谅方法2：使用lambda ----- ConcurrentModificationException
//        list.forEach(name -> {
//            if (name.contains("李")) {
//                list.remove(name);
//            }
//        });
    }
}
