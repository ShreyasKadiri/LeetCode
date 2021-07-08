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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null)      return null;
        int n=1;
        ListNode tail=head;
        while(tail.next!=null){
            n++;
            tail=tail.next;
        }

        k=k%n;
        if(k==0)
            return head;
        
        int steps=n-k;
        tail.next=head;
        ListNode newTail=tail;
        while(steps-- > 0){
            newTail=newTail.next;
        }
        
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
}