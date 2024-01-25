package LinkedList;

/**
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerList = new ListNode();
        ListNode smallerListHead = smallerList;
        ListNode greaterOrEqualList = new ListNode();
        ListNode greaterOrEqualHead = greaterOrEqualList;
        ListNode pointer = head;

        //if head or head.next are null return head.
        if (head == null || head.next == null)
        {
            return head;
        }

        while (pointer != null)
        {
            if (pointer.val < x)
            {
                //Add < node to smallerList.
                smallerList.next = pointer;
                smallerList = smallerList.next;
            }
            else
            {
                //Add >= node to greaterOrEqualList. 
                greaterOrEqualList.next = pointer;
                greaterOrEqualList = greaterOrEqualList.next;
            }
            
            pointer = pointer.next;
        }

        //greaterOrEqualList pointer is the tail, make next null.
        //Assign smallerList pointer next to head of greaterOrEqualList.
        greaterOrEqualList.next = null;
        smallerList.next = greaterOrEqualHead.next;
        return smallerListHead.next;
    }
}
