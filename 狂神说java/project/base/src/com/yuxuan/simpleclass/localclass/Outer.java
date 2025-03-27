package com.yuxuan.simpleclass.localclass;

/**
 * @ClassName Outer
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/27 9:47
 */
public class Outer {
    private String name;
    private int age;

    public void show() {
        String address = "beijing";

        class Inner {
            private int phone = 111;

            public void show() {
                System.out.println(Outer.this.name);
                System.out.println(Outer.this.age);
                System.out.println(this.phone);
                System.out.println(address);
            }
        }

        Inner inner = new Inner();
        inner.show();
    }

}
