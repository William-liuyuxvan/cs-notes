package com.base.thread.two;

/**
 * @ClassName StaticProxy
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 11:51
 */
public class StaticProxy {

    public static void main(String[] args) {
        new MarryCompany(new You("15")).HappyMarry();
    }

}

interface Marry {
    void HappyMarry();
}

class You implements Marry {

    private String name;

    public You(String name) {
        this.name = name;
    }

    @Override
    public void HappyMarry() {
        System.out.println("今天" + name + "要结婚啦！");
    }
}

class MarryCompany implements Marry {

    private You target;

    public MarryCompany(You target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后，付尾款");
    }

    private void before() {
        System.out.println("结婚前，布置现场");
    }
}
