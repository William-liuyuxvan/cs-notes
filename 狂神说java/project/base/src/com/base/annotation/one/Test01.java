package com.base.annotation.one;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 15:59
 */
@MyAnnotation()
public class Test01 {

    @MyAnnotation2("好")
    public void test2() {

    }
}

// 自定义注解
// 可以作用在类和方法上
@Target({ElementType.TYPE, ElementType.METHOD})
// 注解生存到运行时
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    // 定义注解中的参数 : 类型 名称 + ()
    // 可以添加default来提示有默认值，在使用该注解时可以不用添加值
    String name() default "";
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 只有一个参数 建议用 value 命名，这样在使用的时候可以不用添加参数名进行使用
    String value();
}