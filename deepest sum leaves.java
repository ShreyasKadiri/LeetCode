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
   private int maximumLevel = 0;
    private int currentSum = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) {
            return 0;
        }       
        calculateLevelSum(root,0);
        return currentSum;
    }
    
    private void calculateLevelSum(TreeNode root,int currentLevel){
       if(root == null) {
           return ;
       }    
        if(currentLevel > maximumLevel){
            currentSum = 0;
            maximumLevel = currentLevel;
        }
        if(currentLevel == maximumLevel){
            currentSum = currentSum + root.val;
        }
        calculateLevelSum(root.left, currentLevel+1);
        calculateLevelSum(root.right, currentLevel+1);
    }
}
