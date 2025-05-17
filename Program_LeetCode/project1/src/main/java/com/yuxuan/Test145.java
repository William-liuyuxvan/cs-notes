package com.yuxuan;

import java.util.*;

/**
 * @ClassName Test145
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/16 11:01
 */
public class Test145 {
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> list = new LinkedList<>();

    //     traversal(root, list);

    //     return list;
    // }

    // public void traversal(TreeNode root, List list) {
    //     if (root == null) return;

    //     traversal(root.left, list);
    //     traversal(root.right, list);
    //     list.add(root.val);
    // }

    // 栈  左 - 右 - 中
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();

    //     if (root == null) return res;

    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     while (!stack.empty()) {
    //         TreeNode cur = stack.pop();
    //         res.add(cur.val);
    //         if (cur.left != null) {
    //             stack.push(cur.left);
    //         }
    //         if (cur.right != null) {
    //             stack.push(cur.right);
    //         }
    //     }
    //     Collections.reverse(res);

    //     return res;
    // }

    // 迭代法  左 - 右 - 中
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                stack.push(cur);
                stack.push(null);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            } else {
                cur = stack.pop();
                res.add(cur.val);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new Test145().postorderTraversal(root);
    }
}


