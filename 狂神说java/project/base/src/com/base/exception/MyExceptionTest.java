package com.base.exception;

/**
 * @ClassName MyExceptionTest
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/26 20:28
 */
public class MyExceptionTest {
    public static void main(String[] args) {
        int num = 11;
        try {
            test(num);
        } catch (MyException e) {
            System.out.println(e);;
        }
    }

    private static void test(int num) throws MyException {

        System.out.println("num = " + num);

        if (num > 10) {
            throw new MyException(num);
        }
    }

}
