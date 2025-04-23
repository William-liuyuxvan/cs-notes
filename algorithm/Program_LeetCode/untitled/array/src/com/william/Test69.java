package com.william;

/**
 * @ClassName Test69
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/19 22:07
 */
public class Test69 {
    public int mySqrt(int x) {
        if (x >= 2147395600) return 46340;

        int i = 1;
        int len = x / 2;
        while (x >= i * i) {
            i++;
        }

        return i - 1;
    }
}
