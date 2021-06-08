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
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int value){
        if(root == null){
            return 0;
        }
            int totalSum = 0;
        value = value << 1 | root.val;
        //Single path
        while(root.left==null && root.right==null){
            return root.val;
        }
        totalSum+= dfs(root.left, value);
        totalSum+= dfs(root.right, value);
        
        return totalSum;
    }
}
