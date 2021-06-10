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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sumDepth = dfs(root, targetSum);
        return targetSum == sumDepth;
    }
    
    public int dfs(TreeNode root, int targetSum){
        int totalSum = 0;
		if(root == null){
            return 0;
        }

		if(root.left == null && root.right == null){
            return root.val;
        }
        totalSum += dfs(root.left, root.val);
		totalSum += dfs(root.right, root.val);
		return totalSum;
    }
}
