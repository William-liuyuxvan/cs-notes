package com.yuxuan;

/**
 * @ClassName Test344
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/29 11:36
 */
public class Test344 {
    // 自实现
//    public void reverseString(char[] s) {
//        int left = 0, right = s.length - 1;
//        while (left < right) {
//            char temp = s[left];
//            s[left] = s[right];
//            s[right] = temp;
//
//            left++;
//            right--;
//        }
//    }

    // 按位异或
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];

            left++;
            right--;
        }
    }
}
