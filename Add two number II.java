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


//Using Recursion
class Solution {
    int carry=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1==null || l2==null) 
            return l1!=null ? l1 : l2;
        int h1=height(l1);
        int h2=height(l2);
        ListNode result;
        
        if (h1>h2){
            result=add(l1,l2,h1-h2);
        }else {
            result=add(l2,l1,h2-h1);
        }
        if(carry>0) {
            ListNode node=new ListNode(1);
            node.next=result;
            result=node;
        }
        return result;
    }
    
    
    public int height(ListNode node){
        if(node==null)
            return 0;
        return height(node.next)+1;}
    
    public ListNode add(ListNode l1, ListNode l2, int skip) {
        carry=0;
        
        if(l1==null && l2==null) 
            return null;
        ListNode next1=null;
        ListNode next2=l2;
        if (skip<=0){
            next2=l2.next;}
        next1=l1.next;
        ListNode nextNode=add(next1, next2, skip-1);
        int sum=l1.val+(skip<=0 ? l2.val:0) + carry;
        int val=(sum%10);
        carry=(sum/10);
        ListNode result=new ListNode(val);
        result.next=nextNode;
        return result;
    }
}



//Using Stack
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1==null || l2==null)
            return l1!=null ? l1:l2;
        Stack<Integer> stack1=new Stack<Integer>();
        Stack<Integer> stack2=new Stack<Integer>();
        addToStack(stack1,l1);
        addToStack(stack2,l2);
        ListNode result=null;
        int carry=0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop())+ 
                      (stack2.isEmpty() ? 0 : stack2.pop())+carry;
            int value=sum%10;
            carry=sum/10;
            ListNode newNode = new ListNode(value);
            newNode.next = result;
            result = newNode;
        }
        
        if (carry>0){
            ListNode newNode=new ListNode(1);
            newNode.next=result;
            result=newNode;
        }
        return result;
    }
    
    private void addToStack(Stack<Integer> stack, ListNode node) {
        while (node!=null){
            stack.push(node.val);
            node=node.next;
        }
    }
}