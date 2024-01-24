package LinkedList;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
 
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode();
        ListNode current = result; 

        while (l1 != null || l2 != null || carry != 0)
        {
            if (l1 != null)
            {
                carry += l1.val;
                l1 = l1.next;
            }

            if (l2 != null)
            {
                carry += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(carry % 10);
            carry /= 10;
            current.next = node;
            current = current.next;
        }
        return result.next;
    }
}
