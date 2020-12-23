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
 TreeNode previousNode= null;
    int minDifference=Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return 0;
        }
        findMinimum(root);
        return minDifference;
    }
    
    private void findMinimum(TreeNode root) {
        if(root != null) {
            findMinimum(root.left);
            
            if(previousNode!=null) {
                minDifference=Math.min(minDifference, Math.abs(previousNode.val - root.val));
            }
            previousNode=root;
            findMinimum(root.right);
        }
    }   
}
