package com.yuxuan;

/**
 * @ClassName Test19
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/24 16:50
 */
public class Test19 {
    // 自实现  遍历数节点数
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     int cnt = 0;

    //     ListNode cntNode = head;
    //     while (cntNode != null) {
    //         cnt++;
    //         cntNode = cntNode.next;
    //     }

    //     int index = cnt - n;
    //     ListNode dummyHead = new ListNode(0, head);
    //     ListNode cur = dummyHead;
    //     for (int i = 0; i < index; i++) {
    //         cur = cur.next;
    //     }

    //     cur.next = cur.next.next;

    //     return dummyHead.next;
    // }

    // 快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead, fast = dummyHead;

        // fast指针向前走 n+1 步，方便后续slow指针同步进行
        while (n-- >= 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
