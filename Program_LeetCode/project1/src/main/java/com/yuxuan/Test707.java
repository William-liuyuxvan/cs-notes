package com.yuxuan;

/**
 * @ClassName Test707
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/24 14:20
 */
public class Test707 {
    class LinkList {
        int val;
        LinkList next;

        LinkList() {
        }

        LinkList(int val) {
            this.val = val;
        }

        LinkList(int val, LinkList next) {
            this.val = val;
            this.next = next;
        }
    }

    LinkList head;
    int length; // 不算head

    public Test707() {
        init();
    }

    private void init() {
        this.head = new LinkList(0);
        this.length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= length) return -1;

        LinkList p = this.head;
        int findIndex = index;
        while (findIndex-- >= 0) {
            p = p.next;
        }

        return p.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) return;

        LinkList p = this.head;
        while (--index >= 0) {
            p = p.next;
        }

        LinkList addNode = new LinkList(val, p.next);
        p.next = addNode;
        this.length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) return;

        LinkList p = this.head;
        while (--index >= 0) {
            p = p.next;
        }

        p.next = p.next.next;
        this.length--;
    }

    public void printList() {
        LinkList p = head;

        System.out.println("========================");

        for (int i = 0; i < length && p.next != null; i++) {
            System.out.println(i + " : " + p.next.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Test707 myLinkedList = new Test707();
        myLinkedList.printList();
        myLinkedList.addAtHead(1);
        myLinkedList.printList();
        myLinkedList.addAtTail(3);
        myLinkedList.printList();
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        myLinkedList.printList();
        myLinkedList.get(1);              // 返回 2
        myLinkedList.printList();
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        myLinkedList.printList();
        myLinkedList.get(1);              // 返回 3
        myLinkedList.printList();
    }
}
