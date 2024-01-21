package LinkedList;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */


 //Definition for singly-linked list. 
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
 
/**
 * This solution uses Floyd's tortoise and hare algorithm for cycle detection.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow)
            {
                return true;
            }
        }

        return false;
    }
}
