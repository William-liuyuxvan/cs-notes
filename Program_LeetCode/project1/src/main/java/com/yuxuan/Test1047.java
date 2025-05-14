package com.yuxuan;

import java.util.ArrayDeque;

/**
 * @ClassName Test1047
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/14 11:16
 */
public class Test1047 {

    // 自实现
    // public String removeDuplicates(String s) {
    //     if (s.length() <= 1) return s;

    //     int slow = 0, fast = 1;

    //     while (fast < s.length()) {
    //         int temp = fast;
    //         if (fast < s.length() && s.charAt(fast) == s.charAt(fast - 1)) fast++;

    //         if (temp != fast) {
    //             String str1 = slow == 0 ? "" : s.substring(0, slow);
    //             String str2 = fast == s.length() ? "" : s.substring(fast);
    //             s = str1 + str2;
    //             fast = slow == 0 ? 1 : slow;
    //             slow = slow - 1 < 0 ? 0 : slow - 1;
    //         } else {
    //             slow++;
    //             fast++;
    //         }
    //     }

    //     return s;
    // }

    // 堆栈
    public String removeDuplicates(String s) {
        if (s.length() <= 1) return s;

        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else {
                deque.pop();
            }
        }

        String str = "";

        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }

        return str;
    }

    public static void main(String[] args) {
        String s = new Test1047().removeDuplicates("aaaaaaaaa");
        System.out.println(s);
    }
}
