package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test20
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/14 10:37
 */
public class Test20 {
    // 自实现
    // public boolean isValid(String s) {
    //     if (s == null || s.isEmpty() || s.length() % 2 != 0) return false;

    //     Stack<Character> stackIn = new Stack<>();

    //     char[] chArr = s.toCharArray();
    //     for (char ch : chArr) {
    //         if (ch == '(' || ch == '[' || ch == '{') {
    //             stackIn.push(ch);
    //         } else {
    //             if (stackIn.empty()) return false;
    //             if (ch == ')') {
    //                 if (stackIn.pop() != '(') return false;
    //             } else if (ch == ']') {
    //                 if (stackIn.pop() != '[') return false;
    //             } else if (ch == '}') {
    //                 if (stackIn.pop() != '{') return false;
    //             }
    //         }
    //     }

    //     if (stackIn.empty()) return true;
    //     return false;
    // }

    // Stack实现
    // public boolean isValid(String s) {
    //     if (s == null || s.isEmpty() || s.length() % 2 != 0) return false;

    //     Stack<Character> stackIn = new Stack<>();

    //     for (char ch : s.toCharArray()) {
    //         if (ch == ')' && !stackIn.empty() && stackIn.peek() == '(') {
    //             stackIn.pop();
    //         } else if (ch == ']' && !stackIn.empty() && stackIn.peek() == '[') {
    //             stackIn.pop();
    //         } else if (ch == '}' && !stackIn.empty() && stackIn.peek() == '{') {
    //             stackIn.pop();
    //         } else {
    //             stackIn.push(ch);
    //         }
    //     }

    //     return stackIn.empty();
    // }

    // Deque实现
    public boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0) return false;

        Deque<Character> deque = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')' && !deque.isEmpty() && deque.peek() == '(') {
                deque.pop();
            } else if (ch == ']' && !deque.isEmpty() && deque.peek() == '[') {
                deque.pop();
            } else if (ch == '}' && !deque.isEmpty() && deque.peek() == '{') {
                deque.pop();
            } else {
                deque.push(ch);
            }
        }

        return deque.isEmpty();
    }
}
