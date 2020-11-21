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
        if(l1==null && l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        
        if(l2==null){
            return l1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        ListNode curr = null;

        curr = l1;
        while(curr!=null){
            minHeap.add(curr.val);
            curr=curr.next;
        }
        
         curr = l2;
        while(curr!=null){
            minHeap.add(curr.val);
            curr=curr.next;
        }
        
        curr = new ListNode((int) minHeap.poll());
        ListNode mergedHead = curr;
        while (minHeap.size()!=0) {
            curr.next = new ListNode((int) minHeap.poll());
            curr=curr.next;
        }
        return mergedHead;
    }
}
