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
    public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr;
    if (head==null || head.next ==null || k==1)  return head;
    ListNode dummyhead = new ListNode(-1);
    dummyhead.next = head;
    curr=dummyhead;
    int i=0;
    while (head != null){
    	    i++;
    	if (i%k == 0){
    		curr=reverseList( curr, head.next);
    		head =curr.next;
    	} else {
    		head = head.next;
    	}
    }
    return dummyhead.next;
    
}

public ListNode reverseList(ListNode begin, ListNode end){
	ListNode currNode = begin.next;
	ListNode next, first;
	ListNode prev = begin;
	first = currNode;
	while (currNode!=end){
		next =currNode.next;
		currNode.next = prev;
		prev =currNode;
		currNode= next;
	}
	begin.next = prev;
	first.next = currNode;
	return first;
}
}
