package com.base.struct;

/**
 * @ClassName breakGoto
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/24 20:48
 */
public class breakGoto {
    public static void main(String[] args) {
        le: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(" i = "+i + " j = " + j + " i * j = " + i * j);
                if (i * j  >=  5) {
                    System.out.println("break");
                    break le;
                }
            }
        }
    }
}
