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
    ListNode head;
    Random r;
    public Solution(ListNode head) {
        this.head = head;
        r = new Random();
    }
    
    public int getRandom() {
        int value = 0;
        ListNode currentNode = head;
        ListNode candidate = head;
        while(currentNode != null) {
            if(r.nextInt(++value) == 0){
                candidate = currentNode;
            }
            currentNode = currentNode.next;
        }
        return candidate.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
