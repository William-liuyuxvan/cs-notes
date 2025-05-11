package com.yuxuan;

/**
 * @ClassName test
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/24 10:08
 */
public class ListNode {
    // 节点的值
    int val;

    // 指向下一个节点
    ListNode next;

    // 无参构造函数
    public ListNode() {

    }

    // 有参构造函数：val
    public ListNode(int val) {
        this.val = val;
    }

    // 有参构造函数：val nextListNode
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
