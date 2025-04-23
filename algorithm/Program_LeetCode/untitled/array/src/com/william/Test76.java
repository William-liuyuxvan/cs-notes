package com.william;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test76
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/21 10:02
 */
public class Test76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();

        // 记录t（目标字符串）的字符
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int count = 0; // 字符串长度
        String ans = "";
        for (int right = 0; right < s.length(); right++) {
            char chRight = s.charAt(right);
            mapS.put(chRight, mapS.getOrDefault(chRight, 0) + 1);
            if (mapS.get(chRight) <= mapT.getOrDefault(chRight, 0)) {
                count++;
            }
            while (left <= right && mapS.get(s.charAt(left)) > mapT.getOrDefault(s.charAt(left), 0)) {
                mapS.put(s.charAt(left), mapS.get(s.charAt(left)) - 1);
                left++;
            }
            if (count == t.length()) {
                if (ans.equals("") || right - left + 1 < ans.length()) {
                    ans = s.substring(left, right + 1);
                }
            }
        }

        return ans;
    }
}
