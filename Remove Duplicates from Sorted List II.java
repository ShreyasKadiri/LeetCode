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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0, head);
        ListNode previousNode = result;
        
        while (head!=null) {
            if (head.next!=null && head.val==head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;    
                }
                // skip all duplicates
                previousNode.next=head.next;     
            // otherwise, move predecessor
            } else {
                previousNode=previousNode.next;    
            }
            head = head.next;    
        }  
        return result.next;
    }
}
