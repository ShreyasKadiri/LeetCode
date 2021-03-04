/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA==null || headB==null){
        return null;
    } 
    
    ListNode p = headA;
    ListNode q = headB;
    
    while(p!=q){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        p = p == null? headB : p.next;
        q = q == null? headA : q.next;    
    }
    return p;
 }
}
