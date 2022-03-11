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
        if(head == null){
            return null;
        }      
        int count = 1;
        ListNode tail = head;
        while(tail.next != null){
            count++;
            tail = tail.next;
        }
        k = k%count;
        if(k == 0){
            return head;
        }
        int steps = count - k;
        tail.next = head;
        ListNode newTail = tail;
        while(steps-- > 0){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
