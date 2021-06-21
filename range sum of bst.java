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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        
        while(root!=null){
            if(root.left!=null){
                if(root.val>=low && root.val<=high){
                    sum+= root.val;
                    root = root.left;
                }
            }
            if(root.right!=null){
                if(root.val>=low && root.val<=high){
                    sum+= root.val;
                    root = root.right;
                }
            }
        }
        return sum;
    }
}
