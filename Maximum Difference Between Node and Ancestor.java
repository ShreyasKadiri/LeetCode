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


/*
Approach: We maintain the maximum and minimum values and traverse the tree in postorder traversal

*/
class Solution {
    private int maximumDifference = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return maximumDifference;
        }
        dfs(root);
        return maximumDifference;
    }
    
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        
        int left[] = dfs(root.left);
        int right[] = dfs(root.right);
        
        int leftMinimum = left[0];
        int rightMinimum = right[0];
        int leftMaximum = left[1];
        int rightMaximum = right[1];
        
        int minimum = Math.min(root.val, Math.min(leftMinimum, rightMinimum));
        int maximum = Math.max(root.val, Math.max(leftMaximum, rightMaximum));
        maximumDifference = Math.max(Math.max(maximum - root.val,   root.val-minimum), maximumDifference);
        return new int[]{minimum, maximum};
    }
}
