package LinkedList;

/**
 * https://leetcode.com/problems/rotate-list/
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode pointer = head;

        if (head == null || head.next == null)
        {
            return head;
        }

        int size = 1;

        //Set pointer at last node.
        while (pointer.next != null)
        {
            pointer = pointer.next;
            size++;
        }
        
        //Set last node next to head to form circular linked list.
        pointer.next = head;
        pointer = head;

        //If k is larger than size, reduce unnecessary rotations.
        k = k % size;

        //Find (n-k)th element and set as head.
        for (int i = 0; i < size - k - 1; i++)
        {
            pointer = pointer.next;
        }

        //Keep head as (n-k)th node and set (n-k-1)th node next to null.
        head = pointer.next;
        pointer.next = null;
        return head;
    }
}
