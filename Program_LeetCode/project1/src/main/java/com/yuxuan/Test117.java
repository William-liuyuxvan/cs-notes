package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test117
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/3 18:57
 */
public class Test117 {
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
