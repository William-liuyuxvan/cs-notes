package com.yuxuan;

/**
 * @ClassName Test100
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/6 10:50
 */
public class Test100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    private boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        boolean left = compare(p.left, q.left);
        boolean right = compare(p.right, q.right);

        return left && right;
    }
}
