package com.william;

/**
 * @ClassName Test209
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/21 9:23
 */
public class Test209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0; // 标记起始位置
        int sum = 0; // 区间总和
        int res = Integer.MAX_VALUE; // 最小长度
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j]; // 表示在 i 到 j 区间内的和
            while (sum >= target) {
                int subL = j - i + 1;
                res = Math.min(subL, res);
                sum -= nums[i];
                i++;
            }
        }

        return res == Integer.MAX_VALUE? 0 : res;
    }

    // 暴力解法  运行时间超时
    // public int minSubArrayLen(int target, int[] nums) {
    //     int res = Integer.MAX_VALUE;
    //     for (int i = 0; i < nums.length; i++) {
    //         int sum = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             sum += nums[j];
    //             if (sum >= target) {
    //                 int subL = j - i + 1;
    //                 res = Math.min(res, subL);
    //                 break;
    //             }
    //         }
    //     }

    //     return res == Integer.MAX_VALUE? 0 : res;
    // }
}
