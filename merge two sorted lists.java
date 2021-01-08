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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        ListNode result = new ListNode(-1);
        ListNode currentNode = result;
        
        while(l1!=null){
            minHeap.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            minHeap.add(l2.val);
            l2=l2.next;
        }
        while(!minHeap.isEmpty()){
            currentNode.next = new ListNode(minHeap.poll());
            currentNode = currentNode.next;
        }
        return result.next;
    }
}
