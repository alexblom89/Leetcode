package LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii
 */

 //Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode previous = result;
        
        //Set previous to the node one place before 'left'.
        for (int i = 0; i < left - 1; i++)
        {
            previous = previous.next;
        }

        //Set current node pointer.
        ListNode current = previous.next;

        /**
         * Because 'current' node is not changed in the loop, it moves through the linked list 
         * and allows the ahead pointer to continue changing each iteration, thus reordering the list. 
         * Previous remains the same (the node 1 position prior to 'left').
         */
        for (int i = 0; i < right - left; i++)
        {
            ListNode ahead = current.next; //ahead pointer is 1 place after current.
            current.next = ahead.next;
            ahead.next = previous.next;
            previous.next = ahead;
        }
        
        return result.next;
    }
}
