package com.base.exception;

/**
 * @ClassName MyException
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/26 20:27
 */
public class MyException extends Exception{

    private int detail;

    public MyException(int detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
