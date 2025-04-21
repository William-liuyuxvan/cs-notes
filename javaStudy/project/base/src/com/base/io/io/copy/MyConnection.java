package com.base.io.io.copy;

/**
 * @ClassName MyConnection
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/3 21:20
 */
public class MyConnection implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("自动调用了close()方法");
    }
}
