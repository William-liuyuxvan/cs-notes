package com.yuxuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test15
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/28 21:04
 */
public class Test15 {
    // 双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return ans;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) right--;
                else if (nums[i] + nums[left] + nums[right] < 0) left++;
                else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right])); // 将结果添加到ans中
                    while (left < right && nums[left] == nums[left + 1]) left++; // 去重
                    while (left < right && nums[right] == nums[right - 1]) right--; // 去重

                    left++;
                    right--;
                }
            }
        }
        return ans;
    }

}
