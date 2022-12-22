package com.example.two.pointers;

/*
Task #19

Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]

Example 2:
    Input: head = [1], n = 1
    Output: []

Example 3:
    Input: head = [1,2], n = 1
    Output: [1]
*/
public class RemoveNthNodeFromTheEndOfList {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        ListNode listNode = removeNthFromEnd(head, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 1; i <= n; i++)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
