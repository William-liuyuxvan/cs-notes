package com.yuxuan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName Test232
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/13 10:39
 */
public class Test232 {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public Test232() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }

    public void dumpStackIn() {
        if (!stackOut.empty()) return;
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
