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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       List<Integer> leavesTreeOne = new ArrayList<Integer>();
        List<Integer> leavesTreeTwo = new ArrayList<Integer>();
        dfs(root1, leavesTreeOne);
        dfs(root2, leavesTreeTwo);
        
        return leavesTreeTwo.equals(leavesTreeOne);
    }
    
    private void dfs(TreeNode root, List<Integer> leaves){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            leaves.add(root.val);
        }
        dfs(root.right, leaves);
        dfs(root.left, leaves);
        
        return ;
    }
}
