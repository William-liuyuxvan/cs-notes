package com.base.collectionframework.collectionImp.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/30 21:10
 */
public class Application {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // public static <T> boolean addAll(collection<? super T> c, T...elements)：给集合批量添加元素
        Collections.addAll(list, 10, 10, 20, 30, 40);
        System.out.println(list); // [10, 10, 20, 30, 40]

        // public static void shuffle(List<?>list)：打乱List集合中的元素顺序
        Collections.shuffle(list);
        System.out.println(list); // [30, 20, 10, 40, 10]


        // public static<T> void sort(List<T> list)：对List集合中的元素进行升序排序
        Collections.sort(list);
        System.out.println(list); // [10, 10, 20, 30, 40]

        // public static<T> void sort(List<T>list,Comparator<? super T> c)：对List集合中元素，按照比较器对象指定的规则进行排序
//        Collections.sort(list, Collections.reverseOrder()); // [40, 30, 20, 10, 10]
        Collections.sort(list, (o1, o2) -> Integer.compare(o2, o1)); // [40, 30, 20, 10, 10]

        /*
        对于自定义类 如Student时，1. 需要在Student类中实现Comparable接口中的compareTo方法
        或者 2. 直接在参数Comparator<? super T> c重写方法
         */
        System.out.println(list);

    }
}
