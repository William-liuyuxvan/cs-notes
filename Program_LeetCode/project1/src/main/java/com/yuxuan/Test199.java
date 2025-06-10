package com.yuxuan;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Test199
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/3 17:06
 */
public class Test199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                curList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(curList.get(curList.size() - 1));
        }

        return res;
    }
}
