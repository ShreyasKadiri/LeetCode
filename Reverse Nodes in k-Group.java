/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        if(k == 1 || head == null){
            return head;
        }
        ListNode currentNode = head;
        dummy.next = head;
        int totalNodes = 0;
        while(currentNode!=null){
            totalNodes++;
            currentNode = currentNode.next;
        }
        currentNode = head;
        ListNode nextNode = null;
        ListNode previousNode = dummy;
        
        while(totalNodes >= k){
            currentNode = previousNode.next;
            nextNode = currentNode.next;
            
            for(int i=1; i<k; i++){
                currentNode.next = nextNode.next;
                nextNode.next = previousNode.next;
                previousNode.next = nextNode;
                nextNode = currentNode.next;
            }
            previousNode = currentNode;
            totalNodes-= k;
        }
        return dummy.next;
    }
}
