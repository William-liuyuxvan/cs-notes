package com.yuxuan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Test144
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/16 10:57
 */
public class Test144 {
    //递归
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> res = new LinkedList<>();

    //     traversal(res, root);

    //     return res;
    // }

    // public void traversal(List<Integer> res, TreeNode root) {
    //     if (root == null) return;

    //     res.add(root.val);
    //     traversal(res, root.left);
    //     traversal(res, root.right);
    // }

    // 栈  中 - 左 - 右
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();

    //     if (root == null) return res;

    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     while (!stack.empty()) {
    //         TreeNode cur = stack.pop();
    //         res.add(cur.val);

    //         if (cur.right != null) stack.push(cur.right);
    //         if (cur.left != null) stack.push(cur.left);
    //     }

    //     return res;
    // }

    // 迭代法  中 - 左 - 右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
                stack.push(cur);
                stack.push(null);
            } else {
                cur = stack.pop();
                res.add(cur.val);
            }
        }

        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
