package com.yuxuan;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Test349
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/26 14:19
 */
public class Test349 {
    // 自求解，用set
    // public int[] intersection(int[] nums1, int[] nums2) {
    //     int minLength = Math.min(nums1.length, nums2.length);

    //     int[] ans = new int[1100];
    //     int size = 0;

    //     Set<Integer> visited = new HashSet<>();

    //     for (int i = 0; i < nums1.length; i++) {
    //         visited.add(nums1[i]);
    //     }

    //     for (int i = 0; i < nums2.length; i++) {
    //         if (visited.contains(nums2[i])) {
    //             ans[size++] = nums2[i];
    //             visited.remove(nums2[i]);
    //         }
    //     }

    //     int[] ans2 = new int[size];
    //     for (int i = 0; i < size; i++) {
    //         ans2[i] = ans[i];
    //     }

    //     return ans2;
    // }

    // 推荐方法  用数组：因为题目中有限制长度和数目大小
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] temp = new int[1100];
        int[] ans = new int[1100];
        int size = 0;

        for (int i = 0; i < nums1.length; i++) {
            temp[nums1[i]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            if (temp[nums2[i]] != 0) {
                ans[size++] = nums2[i];
                temp[nums2[i]] = 0;
            }
        }

        int[] ans2 = new int[size];
        for (int i = 0; i < size; i++) {
            ans2[i] = ans[i];
        }

        return ans2;
    }
}
