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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int totalLength = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            totalLength++;
            currentNode = currentNode.next;
        }

        int chunk = totalLength / k;
        int remaining = totalLength % k;

        currentNode = head;
        ListNode previousNode = null;
        int i = 0;
        while(currentNode!= null && i<k) {
            result[i]=currentNode;
            for(int j=0; j<chunk+(remaining > 0 ? 1 : 0);j++) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            previousNode.next = null;
            i++;
            remaining--;
        }
        return result;
    }
}
