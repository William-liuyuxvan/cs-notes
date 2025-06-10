package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test111
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/3 19:08
 */
public class Test111 {
    public int minDepth(TreeNode root) {
        int min = 0;
        Deque<TreeNode> deque = new LinkedList<>();

        if (root != null) deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            min++;
            while (size-- > 0) {
                TreeNode cur = deque.poll();
                if (cur.left != null) deque.offer(cur.left);
                if (cur.right != null) deque.offer(cur.right);
                if (cur.left == null && cur.right == null) return min;
            }
        }

        return min;
    }
}
