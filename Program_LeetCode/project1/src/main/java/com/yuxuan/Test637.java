package com.yuxuan;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Test637
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/3 17:12
 */
public class Test637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        if (root != null) deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            double sum = 0.0;
            int count = size;
            while (size-- > 0) {
                TreeNode node = deque.poll();
                sum += node.val;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }

            res.add(sum / count);
        }

        return res;
    }
}
