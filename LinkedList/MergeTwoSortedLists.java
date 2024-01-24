package LinkedList;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Need one list to build result list, and one to reference result list from the head.
        ListNode result = new ListNode();
        ListNode current = result;

        //Compare lists, place higher node next in result list, increment result to next node.
        while (list1 != null && list2 != null)
        {
            if (list1.val > list2.val)
            {
                current.next = list2;
                list2 = list2.next;
            }
            else 
            {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }

        //In case one list is empty before another, the remaining list current node is
        //assigned to result list.
        if (list1 == null)
        {
            current.next = list2;
        }
        else
        {
            current.next = list1;
        }

        //Because we are starting with null head, return result.next instead of result.
        return result.next;
    }

    /**
     * Recursive solution.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
		if(l1 == null)
        {
            return l2;
        } 
        
		if(l2 == null)
        {
            return l1; 
        } 

		if(l1.val < l2.val)
        {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} 
        else
        {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
}
