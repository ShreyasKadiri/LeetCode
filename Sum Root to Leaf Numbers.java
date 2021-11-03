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
    public int sumNumbers(TreeNode root) {
	return sum(root,0);
    }
    
    public int sum(TreeNode root, int sum){
        if(root==null) 
            return 0;
        if(root.right==null && root.left==null)
            return sum*10+root.val;
        return sum(root.left, sum*10+root.val) + sum(root.right, sum*10+root.val);
    }
}
