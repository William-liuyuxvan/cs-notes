package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test116
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/3 18:37
 */
public class Test116 {
    public Node1 connect(Node1 root) {
        Deque<Node1> deque = new LinkedList<>();

        if (root != null) deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size() - 1;
            Node1 l = deque.poll();
            if (l.left != null) deque.offer(l.left);
            if (l.right != null) deque.offer(l.right);
            while (size-- > 0) {
                Node1 r = deque.poll();
                l.next = r;
                if (r.left != null) deque.offer(r.left);
                if (r.right != null) deque.offer(r.right);
                l = r;
            }
        }

        return root;
    }
}

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
