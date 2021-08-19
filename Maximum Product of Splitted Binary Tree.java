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
     long totalSum = 0 ;
     long maximumProduct = 0;

    public int maxProduct(TreeNode root) {
        dfs(root);
        calculateSubTreeSum(root);
        return (int)(maximumProduct % ((int)Math.pow(10, 9) + 7));
    }

    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        totalSum += (long)root.val;
    }
    public  long calculateSubTreeSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        long leftSubTree = calculateSubTreeSum(root.left);
        long rightSubTree = calculateSubTreeSum(root.right);
        long subTreeSum = leftSubTree + rightSubTree + root.val;
        maximumProduct = Math.max(maximumProduct, (subTreeSum) * (totalSum - subTreeSum));
        return subTreeSum;
    }

}
