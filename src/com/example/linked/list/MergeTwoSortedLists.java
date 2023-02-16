package com.example.linked.list;

/*
https://leetcode.com/problems/merge-two-sorted-lists/
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list.
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        int[] list1 = {1, 2, 4};
        int[] list2 = {1, 3, 4};
        ListNode head1 = LinkedListUtil.fillInList(list1);
        ListNode head2 = LinkedListUtil.fillInList(list2);
        LinkedListUtil.print(mergeTwoLists(head1, head2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode merged = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                merged.next = list2;
                list2 = list2.next;
            } else {
                merged.next = list1;
                list1 = list1.next;
            }
            merged = merged.next;
        }

        if (list1 == null) {
            while (list2 != null) {
                merged.next = list2;
                list2 = list2.next;
                merged = merged.next;
            }
        } else {
            while (list1 != null) {
                merged.next = list1;
                list1 = list1.next;
                merged = merged.next;
            }
        }
        return dummy.next;
    }
}
