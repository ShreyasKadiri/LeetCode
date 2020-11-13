/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//Use BFS
class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        
        Queue<Node> queue =new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            Node prevNode = null;
            while(len-- >0){
                Node currNode = queue.poll();
                
                if(currNode.left!=null){
                    queue.add(currNode.left);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
                if(prevNode!=null){
                    prevNode.next=currNode;
                }
                prevNode=currNode;
                
            }
        }    
        return root;
    }
}