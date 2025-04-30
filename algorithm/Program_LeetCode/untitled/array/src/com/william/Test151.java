package com.william;

/**
 * @ClassName Test151
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/30 8:51
 */
public class Test151 {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s); // 删除多余空格
        reverseString(sb, 0, sb.length() - 1); // 反转整个字符串
        reverseEachWord(sb); // 反转每个单词
        return sb.toString();
    }

    public StringBuilder removeSpace(String s) {
        System.out.println("removeSpace before: " + s);
        StringBuilder ans = new StringBuilder();

        int start = 0, end = s.length() - 1;

        // 移除前后空格
        while (start < s.length() && s.charAt(start) == ' ') start++;
        while (end >= 0 && s.charAt(end) == ' ') end--;

        // 移除中间多余空格
        while (start <= end) {
            char temp = s.charAt(start);
            if (temp != ' ' || ans.charAt(ans.length() - 1) != ' ') {
                ans.append(temp);
            }
            start++;
        }

        System.out.println("removeSpace after: " + ans);

        return ans;
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            start++;
            end--;
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int slow = 0, fast = 0;

        while (fast < sb.length()) {
            while (fast < sb.length() && sb.charAt(fast) != ' ') fast++;

            reverseString(sb, slow, fast - 1);

            slow = ++fast;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test151().reverseWords("  hello world  "));
    }
}
