package com.yuxuan;

/**
 * @ClassName Tesr
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/24 11:41
 */
public class Test203 {
//    public ListNode removeElements(ListNode head, int val) {
//        while (head != null && head.val == val) {
////            ListNode temp = head;
//            head = head.next;
////            temp.next = null;
//        }
//
//        if (head == null) return head;
//
//        ListNode left = head;
//        ListNode right = head.next;
//
//        while (right != null) {
//            if (right.val == val) {
//                right = right.next;
////                left.next.next = null;
//                left.next = right;
//            } else {
//                right = right.next;
//                left = left.next;
//            }
//        }
//
//        return head;
//    }

    // 利用递归实现
//    public ListNode removeNode(ListNode head, int val) {
//        // 空指针返回
//        if (head == null) return head;
//
//        // 递归处理
//        if (head.val == val) {
//            ListNode newHead = removeNode(head.next, val);
//            return newHead;
//        } else {
//            head.next = removeNode(head.next, val);
//            return head;
//        }
//    }

    // 对链表操作简化
    public ListNode removeNode(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
























