package com.base.simpleclass.interclass;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/27 9:24
 */
public class Application {

    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.Inner inner = outer.new Inner();

        Outer.Inner inner2 = new Outer().new Inner();

        inner.show();
    }
}
