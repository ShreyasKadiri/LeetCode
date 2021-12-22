
 /*   public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return ;
        //Head of first list
        ListNode l1=head;

        //Head of second list
        ListNode p=head;
        //Tail of second half
        ListNode q=head;
        //Tail of first half
        ListNode prev=null;
        
        while(q!=null && q.next!=null){
            prev=p;
            p=p.next;
            q=q.next.next;
        }
        prev.next=null;
        ListNode l2 = reverse(p);
        merge(l1,l2);
    }

    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next_node=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next_node;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2){
        while(l1!=null){
            ListNode l1_next=l1.next;
            ListNode l2_next=l2.next;
            l1.next=l2;
            if(l1_next==null) break;
            l2.next=l1_next;
            l1=l1_next;
            l2=l2_next;
        }
    }
}
