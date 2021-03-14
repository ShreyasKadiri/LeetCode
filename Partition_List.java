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
    public ListNode partition(ListNode head, int x) {
        if(head==null)      return null;
        
        ListNode lessDummy= new ListNode(-1);
        ListNode greaterOrEqualDummy= new ListNode(-1);
        ListNode lessIter=lessDummy;
        ListNode greaterOrEqualIter=greaterOrEqualDummy;
        ListNode iter=head;
        
        while(iter!=null)
        {
            if(iter.val<x)
            {
            lessIter.next=iter;
            lessIter=iter;
             }
    
        else if(iter.val>=x)
        {
            greaterOrEqualIter.next=iter;
            greaterOrEqualIter=iter;   
        }
        iter=iter.next;
        greaterOrEqualIter.next=null;
        lessIter.next=greaterOrEqualDummy.next;
        
        }
        
        return lessDummy.next;
    }
}