package com.yuxuan;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/27 10:49
 */
public class Test1 {
    // 自实现
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) return new int[]{i, j};
//            }
//        }
//
//        return null;
//    }

    // 使用map存放值和下标
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.getOrDefault(temp, -1) != -1) {
                return new int[]{map.get(temp), i};
            }

            map.put(nums[i], i);
        }

        return new int[2];
    }
}
