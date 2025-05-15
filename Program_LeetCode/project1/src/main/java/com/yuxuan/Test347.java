package com.yuxuan;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName Test347
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/15 12:44
 */
public class Test347 {
    // 小顶堆
    // public int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> map = new HashMap<>();

    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //     }

    //     PriorityQueue<int[]> pq = new PriorityQueue<>((p0, p1) -> p1[1] - p0[1]);
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         pq.add(new int[]{entry.getKey(), entry.getValue()});
    //     }

    //     int[] res = new int[k];
    //     for (int i = 0; i < k; i++) {
    //         res[i] = pq.poll()[0];
    //     }

    //     return res;
    // }

    // 大顶堆
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((p0, p1) -> p0[1] - p1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;
    }
}
