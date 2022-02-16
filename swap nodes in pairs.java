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
    public ListNode swapPairs(ListNode head) {
        if (head==null) {
            return null;
        }
        if(head.next!=null){
            ListNode curr=head.next;
            head.next=head.next.next;
		    curr.next=head;
		    head=curr;
		    head.next.next=swapPairs(head.next.next);
        }
        return head;
    }
}
