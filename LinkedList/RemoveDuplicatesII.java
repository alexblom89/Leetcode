package LinkedList;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 */

public class RemoveDuplicatesII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode();
        ListNode ahead = head;
        ListNode behind = preHead;
        behind.next = ahead;

        while (ahead != null)
        {
            while (ahead.next != null && ahead.val == ahead.next.val)
            {
                ahead = ahead.next;
            }
            
            //Duplicates have been detected.
            if (behind.next != ahead) 
            {
                behind.next = ahead.next; //Remove duplicates.
                ahead = behind.next; //Reposition pointer.
            }
            else
            {
                //No duplicates.
                behind = behind.next;
                ahead = ahead.next;
            }

        }
        return preHead.next;
    }
}
