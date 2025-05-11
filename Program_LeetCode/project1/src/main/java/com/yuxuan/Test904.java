package com.yuxuan;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test904
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/21 21:43
 */
public class Test904 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int ans = 0;

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
