package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null)
        {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node current = head;

        //Use original Node as key and new Node as value in HashMap (Map values are the copy).
        while (current != null)
        {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        //Add next and random values to copy, from Node data in map key.
        while (current != null)
        {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}
