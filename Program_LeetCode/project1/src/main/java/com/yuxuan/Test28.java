package com.yuxuan;

/**
 * @ClassName Test28
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/11 11:50
 */
public class Test28 {
    // 自实现
    // public int strStr(String haystack, String needle) {
    //     int n = haystack.length();
    //     int m = needle.length();
    //     for (int i = 0; i < n - m + 1; i++) {
    //         if (haystack.charAt(i) == needle.charAt(0)) {
    //             int res = checkSubStr(haystack, i, needle);
    //             if (res != -1) return res;
    //         }
    //     }

    //     return -1;
    // }

    // public int checkSubStr(String source, int start, String target) {
    //     int temp = start;
    //     for (int i = 0; i < target.length(); i++, temp++) {
    //         if (target.charAt(i) != source.charAt(temp)) {
    //             return -1;
    //         }
    //     }

    //     return start;
    // }

    // KMP算法
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        // 获取前缀表
        int[] next = getNext(needle);

        int j = 0; // j 指向needle下标   i 指向haystack下标
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) j++;

            if (j == needle.length()) return i - j + 1;
        }

        return -1;
    }

    public int[] getNext(String needle) {
        int[] res = new int[needle.length()];

        int j = 0; // j 指向前缀尾部    i 指向后缀尾部
        res[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            // 处理不匹配情况
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = res[j - 1];
            }

            // 处理匹配情况
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            res[i] = j;
        }

        return res;
    }

    public static void main(String[] args) {
        Test28 test28 = new Test28();
        System.out.println(test28.strStr("hello", "ll"));
    }
}
