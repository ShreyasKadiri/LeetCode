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
    public boolean isBalanced(TreeNode root) {
        if(root==null){ return true;}
        while(root!=null){
            if(Math.abs(getHeight(root.left)-getHeight(root.right))>1){
                return false;
            }
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    
    public int getHeight(TreeNode root){
        if(root==null){
            return -1;}
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));   
    }
}
