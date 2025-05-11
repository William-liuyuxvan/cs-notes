package com.yuxuan;

/**
 * @ClassName Test704
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/19 19:04
 */
public class Test704 {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || target > 9999 || target < -9999) return -1;
        return searchByTwo(nums, 0, nums.length - 1, target);
    }

    public int searchByTwo(int[] nums, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (right + left) / 2;
        int temp = nums[mid];

        if (target == temp) return mid;
        else if (target > temp) return searchByTwo(nums, mid + 1, right, target);
        else if (target < temp) return searchByTwo(nums, left, mid - 1, target);

        return -1;
    }
}
