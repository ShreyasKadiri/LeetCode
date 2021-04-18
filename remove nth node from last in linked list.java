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
class Solution{
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode(0);
    start.next = head;
    ListNode p = start;
    ListNode q = start;
    
    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        q = q.next;
    }
    //Move fast to the end, maintaining the gap
    while(q != null) {
        p = p.next;
        q = q.next;
    }
    //Skip the desired node
    p.next = p.next.next;
    return start.next;
    }
}
