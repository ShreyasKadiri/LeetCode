
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode currentNode = head;
        ListNode previousNode = head;
        while(currentNode != null && currentNode.next != null){
            if (currentNode.next == head) {
                return true;
            }
            currentNode= currentNode.next;
            previousNode.next = head;
            previousNode = currentNode;
        }
        return false;
    }
}
