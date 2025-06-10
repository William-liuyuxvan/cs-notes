package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test559
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/8 10:07
 */
public class Test559 {
    public int maxDepth(Node root) {
        int depth = 0;
        Deque<Node> d = new LinkedList<>();

        if (root != null) d.offer(root);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                Node n = d.poll();
                n.children.forEach(c -> d.offer(c));
            }
            depth++;
        }

        return depth;
    }
}
