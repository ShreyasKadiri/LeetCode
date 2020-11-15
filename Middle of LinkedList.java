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
    public ListNode middleNode(ListNode head) {
            ListNode p=head, q=head;
        
            while(q.next!=null){
                p=p.next;
                if(q.next.next==null) 
                    return p;
                q=q.next.next;
            }
        return p;
    }
}
