
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

class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode o1, ListNode o2) {
        if(o1.val < o2.val){
            return -1;
        }else if(o1.val == o2.val){
            return 0;
        }
        else{
            return 1;
         }
     }
 }

class Solution {
    public ListNode insertionSortList(ListNode head) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        ListNode previousNode = head;
        while(head!=null){
            heap.add(head);
            head = head.next;
            previousNode.next = null;
            previousNode = head;
        }
        ListNode resultNode = new ListNode();
        head = resultNode;
        while(!heap.isEmpty()){
            head.next = heap.poll();
            head = head.next;
        }
        return resultNode.next;
    }
}
