package com.yuxuan;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName Test239
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/15 11:08
 */
public class Test239 {
    // 方法1
    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i > k - 1) {pop(nums[i - k]);}
            push(nums[i]);

            if (i >= k - 1) {
                res[i - k + 1] = arrayDeque.peekFirst();
            }
        }

        return res;
    }

    public void pop(int var) {
        if (!arrayDeque.isEmpty() && arrayDeque.peekFirst() == var) {
            arrayDeque.pollFirst();
        }
    }

    public void push(int var) {
        while (!arrayDeque.isEmpty() && arrayDeque.peekLast() < var) {
            arrayDeque.pollLast();
        }
        arrayDeque.offerLast(var);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}
