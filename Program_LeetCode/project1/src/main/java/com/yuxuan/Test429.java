package com.yuxuan;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Test429
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/3 17:15
 */
public class Test429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Node> deque = new LinkedList<Node>();

        if (root != null) deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                Node node = deque.poll();
                list.add(node.val);
                node.children.forEach(deque::offer);
            }
            res.add(list);
        }

        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};