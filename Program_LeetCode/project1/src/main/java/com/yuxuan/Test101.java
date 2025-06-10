package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test101
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/6 10:03
 */
public class Test101 {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        queue2.add(root);
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            queue1.offer(node.left);
            queue1.offer(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            queue2.offer(node.left);
            queue2.offer(node.right);
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1 == null && node2 == null) continue;
            else if (node1 != null && node2 != null) {
                if (node1.val != node2.val) return false;
            } else {
                return false;
            }
        }

        return true;
    }
}
