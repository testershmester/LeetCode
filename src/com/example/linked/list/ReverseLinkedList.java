package com.example.linked.list;

/*
Task #206
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        ListNode head = LinkedListUtil.fillInList(array);
        LinkedListUtil.print(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
