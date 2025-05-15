package com.yuxuan;

import java.util.Stack;

/**
 * @ClassName Test150
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/15 10:32
 */
public class Test150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            if (!str.equals("-") && !str.equals("+") && !str.equals("*") && !str.equals("/")) {
                stack.push(Integer.parseInt(str));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if (str.equals("-")) b -= a;
                else if (str.equals("+")) b += a;
                else if (str.equals("*")) b *= a;
                else if (str.equals("/")) b /= a;

                stack.push(b);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        new Test150().evalRPN(new String[]{"2","1","+","3","*"});


    }
}
