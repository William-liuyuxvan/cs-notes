package william.com;

/**
 * @ClassName Test367
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/19 22:35
 */
public class Test367 {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;

        int l = 0, r = num;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) mid * mid == num) {
                return true;
            } else if ((long) mid * mid < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
