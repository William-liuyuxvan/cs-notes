package com.yuxuan;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Test515
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/3 17:22
 */
public class Test515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = deque.peek().val;
            while (size-- > 0) {
                TreeNode node = deque.poll();
                max = Math.max(max, node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }

            res.add(max);
        }

        return res;
    }
}
