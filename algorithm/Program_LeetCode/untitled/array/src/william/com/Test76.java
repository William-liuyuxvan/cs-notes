package william.com;

/**
 * @ClassName Test76
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/21 10:02
 */
public class Test76 {
    public String minWindow(String s, String t) {
        int i = 0;
        String res = "";
        String sum = "";
        for (int j = 0; j < s.length(); j++) {
            sum += s.charAt(j);
            if (res.length() >= t.length()) {
                int size = 0;
                int realSize = t.length() * (t.length() - 1) / 2; // 通过角标之和来判断是否满足题意
                for (int k = 0; k < t.length(); k++) {
                    for (int z = 0; z < sum.length(); z++) {
                        if ()
                    }
                }
            }
        }
    }
}
