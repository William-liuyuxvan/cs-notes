package com.yuxuan;

/**
 * @ClassName Test26
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/20 10:42
 */
public class Test26 {
    public int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[slowIndex] != nums[fastIndex]) {
                nums[++slowIndex] = nums[fastIndex];
            }
        }

        return slowIndex + 1;
    }
}
