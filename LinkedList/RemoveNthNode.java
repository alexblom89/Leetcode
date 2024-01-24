package LinkedList;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;

        //Two pointers.
        ListNode current = head;
        ListNode previous = preHead;
        int size = 0;

        //Get list size.
        while (current != null)
        {
            current = current.next;
            size++;
        }

        //Deal with edgecase, if size and n are the same, the answer is always position 1. 
        if (size == n)
        {
            return preHead.next.next;
        }

        int removeIndex = size - n;
        current = head;

        for (int i = 0; i < removeIndex; i++)
        {
            previous = current;
            current = current.next;
            if (i == removeIndex - 1)
            {
                previous.next = current.next;
            }
        }
        
        return preHead.next;
    }

    /**
     * More concise solution with fast and slow pointers. 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head, slow = head;

        for (int i = 0; i < n; i++)
        {
            fast = fast.next;
        } 

        if (fast == null)
        {
            return head.next;
        } 

        while (fast.next != null) 
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

