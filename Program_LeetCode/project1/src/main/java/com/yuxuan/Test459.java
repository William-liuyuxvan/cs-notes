package com.yuxuan;

/**
 * @ClassName Test459
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/11 12:09
 */
public class Test459 {
    // 自实现
    // public boolean repeatedSubstringPattern(String s) {
    //     if (s == null || s.length() <= 1) return false;

    //     int len = s.length();

    //     loge:
    //     for (int i = 1; i <= len / 2; i++) {
    //         String sub = s.substring(0, i);

    //         int start = i;
    //         int end = start + i;
    //         while (end <= len) {
    //             if (!sub.equals(s.substring(start, end))) continue loge;

    //             start = end;
    //             end += i;
    //         }

    //         if (sub.length() + s.length() == end) return true;
    //     }

    //     return false;
    // }

    // KMP算法
    public boolean repeatedSubstringPattern(String s) {
        // 获取前缀表
        int[] next = getNext(s);

//        int res = s.length() - next[next.length - 1];
//        if (res == 0 || res == s.length()) return false;
        return next[next.length - 1] > 0 && s.length() % (s.length() - next[next.length - 1]) == 0;
    }

    public int[] getNext(String s) {
        int[] res = new int[s.length()];

        int j = 0;
        res[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = res[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            res[i] = j;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Test459().repeatedSubstringPattern("abac"));
    }
}
