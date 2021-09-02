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
    public List<TreeNode> generateTrees(int n) {
        return solve(1,n);
    }
    
    private List<TreeNode> solve(int start, int end){
        List<TreeNode> nodes = new ArrayList<>();
        if(start > end){
            nodes.add(null);
            return nodes;
        }if(start == end){
            nodes.add(new TreeNode(start));
            return nodes;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> leftPossibleTrees = solve(start,i-1);
            List<TreeNode> rightPossibleTrees = solve(i+1,end);
            for(TreeNode leftSubTree : leftPossibleTrees){
                for(TreeNode rightSubTree : rightPossibleTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }
}
