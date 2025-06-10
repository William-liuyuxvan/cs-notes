package com.yuxuan;

import java.util.*;

/**
 * @ClassName Test107
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/3 16:58
 */
public class Test107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root != null) deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = deque.poll();
                list.add(node.val);

                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }

            res.add(list);
        }

        Collections.reverse(res);

        return res;
    }
}
