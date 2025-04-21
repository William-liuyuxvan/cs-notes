package com.base.reflection.one;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName Test06
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 21:01
 */
public class Test06 {

    private static final int COUNT = 1000000000;

    // 普通方法
    public static void test01() {
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法循环10亿次：" + (endTime - startTime) + "ms");
    }

    // 反射方法
    public static void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class c1 = Class.forName("com.base.reflection.one.User");

        Method getName = c1.getMethod("getName", null);

        Object user = c1.newInstance();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            getName.invoke(user,  null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方法循环10亿次：" + (endTime - startTime) + "ms");
    }

    // 反射方法  关闭检测
    public static void test03() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class c1 = Class.forName("com.base.reflection.one.User");

        Method getName = c1.getMethod("getName", null);

        Object user = c1.newInstance();
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            getName.invoke(user,  null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭检测反射方法循环10亿次：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        test01(); // 普通方法循环10亿次：3ms
        test02(); // 反射方法循环10亿次：1639ms
        test03(); // 关闭检测反射方法循环10亿次：1046ms
    }
}
