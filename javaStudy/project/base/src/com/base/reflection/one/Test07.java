package com.base.reflection.one;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test07
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 21:19
 */
// 反射获取泛型
public class Test07 {

    public void test01(Map<String, User> map, List<Integer> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // 获取test01中的参数泛型
        System.out.println("获取test01中的参数泛型");
        Method method = Test07.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("    *" + actualTypeArgument);
                }
            }
        }

        System.out.println("========================================");

        // 获取test02中的返回泛型
        System.out.println("获取test02中的返回泛型");
        method = Test07.class.getMethod("test02");
        Type genericReturnType = method.getGenericReturnType();

        System.out.println("#" + genericReturnType);
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("    *" + actualTypeArgument);
            }
        }
    }
}
