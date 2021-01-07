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
    public int minDiffInBST(TreeNode root) {
        List<Integer> result= new ArrayList<Integer>();
        if(root==null) {
            return 0;
        }
        inOrder(root, result);
        int minimumDifference=Integer.MAX_VALUE;
        for(int i=0; i<result.size()-1; i++)
    minimumDifference= Math.min(minimumDifference, result.get(i+1)-result.get(i));
        return minimumDifference;
    }
    
    public void inOrder(TreeNode root, List<Integer> result){
        if(root==null){
            return ;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
        return ;
    }    
}
