package com.example.linked.list.detect.cycle;

/*
Task #142
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        int[] list = {1, 2};
        ListNode head = fillInList(list, -1);
        ListNode listNode = detectCycle(head);
        System.out.println(listNode == null ? "null" : listNode.val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    public static ListNode fillInList(int[] list, int pos) {
        ListNode head = null;
        ListNode current;
        if (list.length != 0) {
            head = new ListNode(list[0]);
            current = head;
            for (int i = 1; i < list.length; i++) {
                current.next = new ListNode(list[i]);
                current = current.next;
            }
            if (pos != -1) {
                ListNode node = head;
                for (int i = 0; i < list.length; i++) {
                    if (i == pos) {
                        current.next = node;
                        break;
                    }
                    node = node.next;
                }
            }
        }
        return head;
    }
}
