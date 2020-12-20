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
    public boolean isSymmetric(TreeNode root) {
       return isMirror(root,root);
    }
    
    
   public boolean isMirror(TreeNode node1, TreeNode node2)  { 
        if(node1==null && node2==null)  return true;  
        if(node1!=null && node2!=null && node1.val==node2.val) 
            return (isMirror(node1.left, node2.right) 
                    && isMirror(node1.right, node2.left)); 
           return false; 
    } 
}
