package com.william;

/**
 * @ClassName Test34
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/19 19:40
 */
public class Test34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return new int[]{-1, -1};

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                left = mid;
                right = mid;
                while ((left - 1) >= 0 && target == nums[left - 1]) left--;
                while ((right + 1) < nums.length && target == nums[right + 1]) right++;
                return new int[]{left, right};
            } else if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return new int[]{-1, -1};
    }
}
