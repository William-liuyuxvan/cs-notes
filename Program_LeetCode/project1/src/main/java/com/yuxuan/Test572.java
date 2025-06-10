package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test572
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/6 10:53
 */
public class Test572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;

        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.offer(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node.val == subRoot.val) {
                boolean b = compare(node, subRoot);
                if (b) return true;
            }
            if (node.left != null) deque.offer(node.left);
            if (node.right != null) deque.offer(node.right);
        }

        return false;
    }

    private boolean compare(TreeNode q, TreeNode p) {
        if (q == null && p == null) return true;

        if (q == null || p == null) return false;

        if (q.val != p.val) return false;

        boolean b = compare(q.left, p.left);
        boolean b1 = compare(q.right, p.right);

        return b && b1;
    }
}
