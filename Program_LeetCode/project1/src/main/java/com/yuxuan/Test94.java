package com.yuxuan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Test94
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/16 11:04
 */
public class Test94 {
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new LinkedList<>();

    //     traversal(root, list);

    //     return list;
    // }

    // void traversal(TreeNode root, List list) {
    //     if (root == null) return;

    //     traversal(root.left, list);
    //     list.add(root.val);
    //     traversal(root.right, list);
    // }

    // 栈  左 - 中 - 右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null)  {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }
}
