/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution{
    int tilt = 0;
    public int findTilt(TreeNode root){
        if(root==null){
            return 0;
        }
        calculateSum(root);
        return tilt; 
    }
    
    
    public int calculateSum(TreeNode root){
        if(root==null){
            return  0;
        }
        int leftSum = calculateSum(root.left);
        int rightSum = calculateSum(root.right);
        tilt+= Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
