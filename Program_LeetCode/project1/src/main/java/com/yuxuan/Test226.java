package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test226
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/6 9:54
 */
public class Test226 {
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }


        return root;
    }
}
