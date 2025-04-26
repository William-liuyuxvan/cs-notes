package com.william;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName test202
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/26 15:00
 */
public class Test202 {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();

        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getSum(n);
        }

        return n == 1;
    }

    public int getSum(int n) {
        int ans = 0;
        while (n != 0) {
            int temp = n % 10;
            ans += (int) Math.pow(temp, 2);
            n /= 10;
        }

        return ans;
    }
}
