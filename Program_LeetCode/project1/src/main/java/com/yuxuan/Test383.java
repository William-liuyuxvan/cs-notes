package com.yuxuan;

/**
 * @ClassName Test383
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/28 21:02
 */
public class Test383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] hash = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            hash[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--hash[ransomNote.charAt(i) - 'a'] < 0) return false;
        }

        return true;
    }
}
