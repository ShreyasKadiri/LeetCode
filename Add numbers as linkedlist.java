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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        sum+=(l1!=null ? l1.val : 0);
        sum+=(l2!=null ? l2.val : 0);
        if(l1==null && l2==null){
            return null;
        }
        if(sum>=10){
            if(l1.next==null){
                l1.next = new ListNode(0);
            }
            l1.next.val = l1.next.val+1;
        }
        ListNode newNode = new ListNode(sum % 10);
        l1 = (l1==null ? new ListNode(0) : l1);
        l2 = (l2==null ? new ListNode(0) : l2);
        newNode.next = addTwoNumbers(l1.next,l2.next);
        
        return newNode;
    }
}