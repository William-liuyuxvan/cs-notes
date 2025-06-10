package com.yuxuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/9 13:55
 */
public class Test110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        if (left == -1) return -1;
        int right = getHeight(root.right);
        if (right == -1) return -1;

        int res = 0;
        if (Math.abs(left - right) > 1) return -1;
        else res = Math.max(left, right) + 1;
        return res;
    }
}
