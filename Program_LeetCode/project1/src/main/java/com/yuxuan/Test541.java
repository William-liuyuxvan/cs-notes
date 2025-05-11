package com.yuxuan;

/**
 * @ClassName Test541
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/29 16:25
 */
public class Test541 {
    // 思路正确，但是无相关函数支持
    // public String reverseStr(String s, int k) {
    //     int cnt = s.length() / (2 * k); // 需要将2k前k个字符反转的次数
    //     int surplus = s.length() % (2 * k); // 剩余的字符个数

    //     for (int i = 0; i < cnt; i++) {
    //         s = reverse(s, i * 2 * k, k);
    //     }

    //     if (surplus < k) {
    //         s = reverse(s, (cnt - 1) * 2 * k, surplus);
    //     } else if (surplus <  2 * k) {
    //         s = reverse(s, (cnt - 1) * 2 * k, k);
    //     }

    //     return s;
    // }


    // public String reverse(String s, int start, int size) {
    //     int left = start, right = start + size - 1;
    //     while (left < right) {
    //         char temp = s.charAt(left);
    //         s.charAt(left) = s.charAt(right);
    //         s.charAt(right) = temp;
    //     }

    //     return s;
    // }

    // 用char[] 来完成
    // public String reverseStr(String s, int k) {
    //     char[] ch = s.toCharArray();
    //     int length = s.length();
    //     for (int i = 0; i < length; i += 2 * k) {
    //         int start = i;
    //         int end = Math.min(length - 1, start + k - 1);

    //         while (start < end) {
    //             ch[start] ^= ch[end];
    //             ch[end] ^= ch[start];
    //             ch[start] ^= ch[end];

    //             start++;
    //             end--;
    //         }
    //     }

    //     return new String(ch);
    // }

    public String reverseStr(String s, int k) {
        StringBuffer ans = new StringBuffer();
        int start = 0;
        int end = s.length();

        while (start < end) {
            StringBuffer temp = new StringBuffer();

            // 获取第一个k的位置
            int firstK = start + k < end ? start + k : end;
            // 获取第二个k的位置
            int secondK = start + 2 * k < end ? start + 2 * k : end;

            temp.append(s.substring(start, firstK));
            ans.append(temp.reverse()); // 反转后添加

            if (firstK < secondK) {
                ans.append(s.substring(firstK, secondK)); // 添加不需要反转的地方
            }

            start += 2 * k;
        }

        return ans.toString();
    }
}
