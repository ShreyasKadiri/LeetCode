/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q){
            return root;
        }
        if(root == null){
            return null;
        }
        
        TreeNode leftTraversal = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTraversal = lowestCommonAncestor(root.right, p, q);
        
        if(leftTraversal != null && rightTraversal != null){
            return root;
        }
  
        return leftTraversal!=null ? leftTraversal : rightTraversal;
    }
}
