package william.com;

/**
 * @ClassName Test283
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/20 10:50
 */
public class Test283 {
    public void moveZeroes(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }

        while (slowIndex < nums.length) {
            nums[slowIndex++] = 0;
        }
    }
}
