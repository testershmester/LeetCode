package com.example.linked.list;

public class LinkedListUtil {

    public static ListNode fillInList(int[] list) {
        ListNode head = null;
        if (list.length != 0) {
            head = new ListNode(list[0]);
            ListNode current = head;
            for (int i = 1; i < list.length; i++) {
                current.next = new ListNode(list[i]);
                current = current.next;
            }
        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
