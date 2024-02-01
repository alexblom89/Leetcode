package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */

 class LRUCache {
    LinkedNodeList list;
    Map<Integer, Node> map;
    Integer cap;
    
    public LRUCache(int capacity) {
        list = new LinkedNodeList();
        map = new HashMap(capacity);
        cap = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        list.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            list.moveToHead(node);
            node.val = value;

        }else{
             Node newNode = new Node(key, value);
            if(map.size() == cap){
                Node tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }
}

class LinkedNodeList{
    Node dummyHead;
    Node dummyTail;
    
    LinkedNodeList(){
        dummyHead = new Node(0,0);
        dummyTail = new Node(0,0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    void moveToHead(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }
    
    void addToHead(Node node){
        Node tmp = dummyHead.next ;
        dummyHead.next = node;
        node.next = tmp;
        node.prev = dummyHead;
        tmp.prev = node;
    }
    
    void removeTail(){
        Node newTail = dummyTail.prev.prev;
        newTail.next = dummyTail;
        dummyTail.prev = newTail;
    }
    
    Node getTail(){
        return dummyTail.prev;
    }
    
}

 class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key, int value){
        this.key = key;
        this.val =value;
    }
}

/**
 * Prior solution I made, was very similar to site solution but just wouldn't quite work.
 */

//  public class LRUCache {
//     //Double Linked List Node class.
//     class Node
//     {
//         int key;
//         int value;
//         Node previous;
//         Node next;
//     }

//     //The cache will be implemented as a HashMap, where the Key is the given key, and the value 
//     //is the node that stores the actual value of the input. The linked list will maintain
//     //the head and tail positions, where the Most Recently Used and LRU items are placed respectively
//     //(updated with each new access).
//     private Map<Integer, Node> cache = new HashMap<>();
//     private int capacity;
//     private Node head;
//     private Node tail;

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
        
//         //Create empty head and tail, link together to form empty list.
//         head = new Node();
//         tail = new Node();
//         head.previous = null;
//         head.next = tail;
//         tail.previous = head;
//         tail.next = null;
//     }
    
//     public int get(int key) {

//         Node node = cache.get(key);

//         if (node == null)
//         {
//             return -1;
//         }

//         moveToHead(node);
//         return node.value;
//     }
    
//     public void put(int key, int value) 
//     {
//         Node node = cache.get(key);
//         if (node == null)
//         {
//             Node newNode = new Node();
//             newNode.key = key;
//             newNode.value = value;

//             cache.put(key, newNode);
//             addNode(newNode);

//             if (cache.size() >= capacity)
//             {
//                 //Pop the tail.
//                 Node tail = popTail();
//                 cache.remove(tail.key);
//             }
//         }
//         else
//         {
//             //Update value and move to head (not a new node).
//             node.value = value;
//             moveToHead(node);
//         }
//     }

//     //Add new node to head.
//     private void addNode(Node node) 
//     {
//         node.previous = head;
//         node.next = head.next;

//         head.next.previous = node;
//         head.next = node;
//     }

//     //Remove a node from the list.
//     private void removeNode(Node node)
//     {
//         node.previous.next = node.next;
//         node.next.previous = node.previous;
//     }

//     //Remove the LRU node from the tail and return it;
//     private Node popTail()
//     {
//         Node LRU = tail.previous;
//         removeNode(LRU);
//         return LRU;
//     }

//     //Move node to head of list, link node's previous node and next node to fill empty space.
//     private void moveToHead(Node node)
//     {
//         removeNode(node);
//         addNode(node);
//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
