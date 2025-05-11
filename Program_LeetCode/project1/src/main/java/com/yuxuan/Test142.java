package com.yuxuan;

/**
 * @ClassName Test142
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/25 9:16
 */
public class Test142 {
    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // 计算slow和fast走过的路程，然后列出计算公式，得到当从head走，同时从相遇节点走，两个节点都走相同路程，会在环形开头节点相遇。
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }

        return null;
    }
}
