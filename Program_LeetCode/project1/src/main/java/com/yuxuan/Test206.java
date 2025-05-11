package com.yuxuan;

/**
 * @ClassName Test206
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/24 15:06
 */
public class Test206 {
    // 1. 头插法
    // public ListNode reverseList(ListNode head) {
    //     if (head == null || head.next == null) return head;

    //     ListNode newHead = new ListNode(0);

    //     while (head != null) {
    //         ListNode newNode = new ListNode(head.val);
    //         addAtHead(newHead, newNode);
    //         head = head.next;
    //     }

    //     return newHead.next;
    // }

    // public void addAtHead(ListNode head, ListNode node) {
    //     node.next = head.next;
    //     head.next = node;
    // }

    // 2. 直接反转 -- 双指针
    // public ListNode reverseList(ListNode head) {
    //     ListNode temp; // 保存cur的下一个节点
    //     ListNode cur = head; // 指向当前节点
    //     ListNode pre = null; // 指向cur的上一个节点

    //     while (cur != null) {
    //         temp = cur.next;
    //         cur.next = pre;
    //         pre = cur;
    //         cur = temp;
    //     }

    //     return pre;
    // }

    // 3. 递归
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;

        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }
}
