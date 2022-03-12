
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution
{
    public Node copyRandomList(Node head) 
    {
        Map<Node, Node> map = new HashMap<Node,Node>();
        Node curr=head;
        while(curr!=null) 
        {
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }

        Node dummy= new Node(-1); 
        Node dummycurr=dummy;
        curr=head;

        while(curr != null) 
        {
            Node node = map.get(curr);
            Node randomNode = map.get(curr.random);
            node.random = randomNode;
            dummycurr.next = node; 
            dummycurr=dummycurr.next; 
            curr=curr.next; 
        }
        return dummy.next;
    }
}
