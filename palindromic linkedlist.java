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
    public boolean isPalindrome(ListNode head) {
    ListNode p=head;
    ListNode q=head;
    while (q != null && q.next != null) {
        q = q.next.next;
        p = p.next;
    }
    if (q != null) {
        p = p.next;
    }
    p = reverse(p);
    q = head;
    
    while (p!=null) {
        if (q.val!= p.val) {
            return false;
        }
        q = q.next;
        p = p.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
    ListNode previous = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = previous;
        previous = head;
        head = next;
    }
    return previous;
}
}
