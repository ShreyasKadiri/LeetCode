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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        
        TreeNode leftSubTree = pruneTree(root.left);
        if(leftSubTree == null){
            root.left =null;
        }
        
        TreeNode rightSubTree = pruneTree(root.right);
        if(rightSubTree == null){
            root.right =null;
        }
        return leftSubTree!=null || rightSubTree!=null || root.val == 1 ? root : null;
    }
}
