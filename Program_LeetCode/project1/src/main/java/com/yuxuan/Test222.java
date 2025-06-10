package com.yuxuan;

import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverLocalFilesystem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Test222
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/8 10:12
 */
public class Test222 {
    // 递归法
    // public int countNodes(TreeNode root) {
    //     if (root == null) return 0;

    //     return countNodes(root.left) + countNodes(root.right) + 1;
    // }

    // 针对完全二叉树法
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != right) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
