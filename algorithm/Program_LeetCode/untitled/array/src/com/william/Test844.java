package com.william;

/**
 * @ClassName Test844
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/20 11:00
 */
public class Test844 {
//    public boolean backspaceCompare(String s, String t) {
//        String s1 = backspace(s);
//        String t1 = backspace(t);
//        return s1.equals(t1);
//    }
//
//    public String backspace(String str) {
//        int slowIndex = 0, fastIndex = 0;
//        String res = "" + str.charAt(0);
//        while (fastIndex < str.length()) {
//            if (str.charAt(fastIndex) == '#') {
//                res = res.substring(0, --slowIndex);
//            } else {
//                if (res.length() == 0) {
//                    res = "" + str.charAt(fastIndex);
//                    slowIndex++;
//                } else {
//                    res = res.substring(0, ++slowIndex) + str.charAt(fastIndex);
//                }
//            }
//            fastIndex++;
//        }
//
//        return res;
//    }

    public static boolean backspaceCompare(String s, String t) {
        System.out.println(newString(s));
        System.out.println(newString(t));
        return newString(s).equals(newString(t));
    }

    public static String newString(String str) {
        int slow = 0;
        String ans = "";

        for (int fast = 0; fast < str.length(); fast++) {
            if (str.charAt(fast) != '#') {
                ans += str.charAt(fast);
                slow++;
            } else {
                if (slow <= 1) {
                    ans = "";
                    slow = 0;
                } else {
                    ans = ans.substring(0, --slow);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        backspaceCompare("ab#c", "ad#c");
    }
}
