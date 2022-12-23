package com.example.two.pointers;

/*
Task #876

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        ListNode listNode = middleNode(head);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;

        int n = 0;
        while (end.next != null) {
            end = end.next;
            n++;
        }
        for (int i = 1; i <= n / 2; i++) {
            start = start.next;
        }
        return start.next;
    }
}
