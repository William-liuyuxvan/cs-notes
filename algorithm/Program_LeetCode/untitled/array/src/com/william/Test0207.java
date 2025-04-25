package com.william;

/**
 * @ClassName Test0207
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/25 8:28
 */
public class Test0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = countListLength(headA);
        int lengthB = countListLength(headB);

        ListNode pA = headA;
        ListNode pB = headB;

        int differLength = lengthA - lengthB;
        if (differLength > 0) {
            while (differLength-- > 0) {
                pA = pA.next;
            }
        } else if (differLength < 0) {
            while (differLength++ < 0) {
                pB = pB.next;
            }
        }

        while (pA != null && pB != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }

        return null;
    }

    public int countListLength(ListNode list) {
        int ans = 0;
        ListNode p = list;
        while (p != null) {
            ++ans;
            p = p.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode aandb = new ListNode(5);
        ListNode aandb2 = new ListNode(4, aandb);
        ListNode aandb3 = new ListNode(8, aandb2);

        ListNode a = new ListNode(1, aandb3);
        ListNode a2 = new ListNode(4, a);

        ListNode b = new ListNode(1, aandb3);
        ListNode b2 = new ListNode(0, b);
        ListNode b3 = new ListNode(5, b2);

        System.out.println("A");
        ListNode p = a2;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println("\n==========");
        System.out.println("B");
        ListNode p2 = b3;
        while (p2 != null) {
            System.out.print(p2.val + " ");
            p2 = p2.next;
        }
        System.out.println("\n==========");

        new Test0207().getIntersectionNode(a2, b3);
    }
}
