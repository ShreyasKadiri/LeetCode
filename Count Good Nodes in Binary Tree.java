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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maximum = root.val;
        return dfs(root, maximum);
    }
    
    private int dfs(TreeNode root, int maximum){
        if(root == null){
            return 0;
        }
        maximum = Math.max(maximum, root.val);
        if(root.val >= maximum){
            return 1 + dfs(root.left, maximum) + dfs(root.right, maximum);
        }else{
            return dfs(root.left, maximum) + dfs(root.right, maximum);
        }
    }
}
