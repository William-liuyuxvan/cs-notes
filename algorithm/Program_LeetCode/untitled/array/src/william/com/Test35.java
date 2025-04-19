package william.com;

/**
 * @ClassName Test35
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/19 19:30
 */
public class Test35 {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}
