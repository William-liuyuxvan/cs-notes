package com.yuxuan;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Test225
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/13 11:09
 */
public class Test225 {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2; // 用来备份

    public Test225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
