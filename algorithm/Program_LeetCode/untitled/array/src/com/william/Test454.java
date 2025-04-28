package com.william;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test454
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/27 11:15
 */
public class Test454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        // 存放nums1和nums2的和
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;

        // 遍历nums3和nums4
        for (int i : nums3) {
            for (int j : nums4) {
                ans += map.getOrDefault(-(i + j), 0);
            }
        }

        return ans;
    }
}
