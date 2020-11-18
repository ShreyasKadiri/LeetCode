/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    private Queue<TreeNode> queue;
    public BSTIterator(TreeNode root) {
        queue=new LinkedList<>();
        if(root!= null){
           binarySearchTree(root); 
        }
    }

    private void binarySearchTree(TreeNode node){
        if(node.left!= null){
            binarySearchTree(node.left);
        }
        queue.add(node);
        if(node.right!= null){
            binarySearchTree(node.right);
        }
    }
    
    /** @return the next smallest number */
    public int next() {
     return queue.poll().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.peek() != null;

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */