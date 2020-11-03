/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their 
nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.


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
