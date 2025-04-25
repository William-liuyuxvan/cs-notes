package com.william;

/**
 * @ClassName Test242
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/25 14:51
 */
public class Test242 {
    // 自实现：assci
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) return false;

    //     int[] sArr = new int[256];
    //     int[] tArr = new int[256];
    //     for (int i = 0; i < s.length(); i++) {
    //         sArr[s.charAt(i)]++;
    //     }
    //     for (int i = 0; i < t.length(); i++) {
    //         tArr[t.charAt(i)]++;
    //     }

    //     for (int i = 0; i < sArr.length; i++) {
    //         if (sArr[i] != tArr[i]) return false;
    //     }
    //     return true;
    // }

    // 优化：通过hashcode
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] record = new int[26]; // 26个字母
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) return false;
        }

        return true;
    }
}
