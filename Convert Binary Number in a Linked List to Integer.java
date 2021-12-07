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
        if(head == null){
            return -1;
        }
        String result = "";
        ListNode currentNode = head;
        while(currentNode!=null){
            result+=String.valueOf(currentNode.val);
            currentNode = currentNode.next;
        }
        return Integer.parseInt(result,2);
    }
}


//Bitwise
class Solution {
    public int getDecimalValue(ListNode head) {
        if(head == null){
            return -1;
        }
        int sum = 0;
        while(head!=null){
            sum = sum*2 + head.val;
            head= head.next;
        }
        return sum;
    }
}
