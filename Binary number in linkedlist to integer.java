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
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder("");
        ListNode currentNode = head;
        while(currentNode!=null){
            sb.append(currentNode.val);
            currentNode = currentNode.next;
        }
        return Integer.parseInt(sb.toString(),2);
    }
}
