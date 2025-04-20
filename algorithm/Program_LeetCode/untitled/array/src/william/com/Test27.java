package william.com;

/**
 * @ClassName Test27
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/20 10:08
 */
public class Test27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }

        return slowIndex;
    }
}
