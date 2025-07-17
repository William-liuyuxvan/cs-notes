package com.yuxuan;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Test257
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/12 11:21
 */
public class Test257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        return dfs(root, res, queue);
    }

    private List<String> dfs(TreeNode root, List<String> path, Deque<TreeNode> queue) {
        queue.offer(root);

        if (root.left == null && root.right == null) {
            printTreePath(path, queue);
        }
        if (root.left != null) {
            dfs(root.left, path, queue);
            queue.pollLast();
        }
        if (root.right != null) {
            dfs(root.right, path, queue);
            queue.pollLast();
        }

        return path;
    }

    public void printTreePath(List<String> path, Deque<TreeNode> queue) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for (TreeNode node: queue) {
            if (!flag) {
                sb.append("->");
            }

            sb.append(node.val);
            flag = false;
        }

        path.add(sb.toString());
    }
}
