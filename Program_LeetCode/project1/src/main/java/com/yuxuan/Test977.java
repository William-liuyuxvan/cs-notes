package com.yuxuan;

import java.util.Arrays;

/**
 * @ClassName Test977
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/20 14:29
 */
public class Test977 {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0, j = len - 1, pos = len - 1; i <= j;) {
            if ((nums[i] * nums[i]) > (nums[j] * nums[j])) {
                res[pos] = nums[i] * nums[i];
                ++i;
            } else {
                res[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }

        return res;
    }
}
