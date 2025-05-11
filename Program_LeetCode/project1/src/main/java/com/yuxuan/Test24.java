package com.yuxuan;

/**
 * @ClassName Test24
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/24 16:22
 */
public class Test24 {
    // 自实现
    // public ListNode swapPairs(ListNode head) {
    //     if (head == null || head.next == null) return head;

    //     ListNode temp = head; // 保存right的下一个节点
    //     ListNode left;
    //     ListNode right;
    //     ListNode preHead = new ListNode(0);
    //     ListNode p = preHead;

    //     // 考虑到奇数情况
    //     while (temp != null && temp.next != null) {
    //         left = temp;
    //         right = temp.next;
    //         temp = right.next;

    //         p.next = right;
    //         p = left;

    //         left.next = right.next;
    //         right.next = left;
    //     }

    //     return preHead.next;
    // }

    // 优化后
    public ListNode swapPairs(ListNode head) {
        ListNode left;
        ListNode right;
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;

        // 考虑到奇数情况
        while (cur.next != null && cur.next.next != null) {
            left = cur.next;
            right = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = left;
            left.next = right;
            cur = left;
        }

        return dummyHead.next;
    }
}
