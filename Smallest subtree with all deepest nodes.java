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
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null){ return null;}
        int leftDepth=getDepth(root.left);  
        int rightDepth=getDepth(root.right);
        if(leftDepth==rightDepth) {return root;}
        else {
            if(leftDepth>rightDepth){
                return subtreeWithAllDeepest(root.left);
            } else {
                return subtreeWithAllDeepest(root.right);
            }
        }
    }
    
    public int getDepth(TreeNode node) {
        if (node==null) {
            return 0;}
        return 1+Math.max(getDepth(node.left),getDepth(node.right)); 
    }
}