class Solution 
{
    public ListNode removeElements(ListNode head, int val)
    {
        if(head==null)
            return null;
        ListNode curr=head;
       // ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
        while(curr!=null && curr.val==val) {
        curr=curr.next;}
            if(prev!=null)
            {
            if(curr==null) 
            prev.next=null;
            else 
            prev.next=curr;
            }
            else
                head=curr;
            prev=curr;
            curr=curr!=null?curr.next:null;
        }
        return head;
    }
}
