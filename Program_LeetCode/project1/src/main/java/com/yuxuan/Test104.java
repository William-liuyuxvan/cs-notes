package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Test104
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/3 19:02
 */
public class Test104 {
    public int maxDepth(TreeNode root) {
        int dep = 0;
        Deque<TreeNode> deque = new LinkedList<>();

        if (root != null) deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            dep++;
        }

        return dep;
    }
}
