package com.yuxuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test18
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/29 10:44
 */
public class Test18 {
    // 自实现
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//
//        List<List<Integer>> ans = new ArrayList<>();
//
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length; i++) {
//            // if (nums[i] > target) return ans;
//            // i 去重
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//
//            for (int j = nums.length - 1; j > i; j--) {
//                if (i >= j) return ans;
//
//                // if (j < target) return ans;
//
//                // j 去重
//                if (j < nums.length - 1 && nums[j] == nums[j + 1]) continue;
//
//                int left = i + 1, right = j - 1;
//                while (left < right) {
//                    if ((long) nums[i] + nums[left] + nums[right] + nums[j] > target) right--;
//                    else if ((long) nums[i] + nums[left] + nums[right] + nums[j] < target) left++;
//                    else {
//                        ans.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
//                        while (left < right && nums[left] == nums[left + 1]) left++;
//                        while (left < right && nums[right] == nums[right - 1]) right--;
//                        left++;
//                        right--;
//                    }
//                }
//            }
//        }
//
//        return ans;
//    }

    // 优化
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (nums[i] > target && nums[i] >= 0) break;

            // i 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 1; j++) {
                // 剪枝
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) break;

                // j 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[left] + nums[right] + nums[j];
                    if (sum > target) right--;
                    else if (sum < target) left++;
                    else {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Test18().fourSum(new int[]{-3,-1,0,2,4,5}, 0);
        for (List<Integer> list : lists) {
            for (Integer integer : list)
                System.out.print(integer + " ");
        }
    }
}
