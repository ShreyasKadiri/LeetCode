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
   private int maxLevel = 0;
    private int sum = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) {
            return 0;
        }       
        calculateLevelSum(root,0);
        return sum;
    }
    
    private void calculateSumAtLevel(TreeNode root,int level){
       if(root == null) {
           return ;
       }    
        if(currentLevel > maximumLevel){
            currentSum = 0;
            maximumLevel = currentLevel;
        }
        if(level == maxLevel){
            currentSum = currentSum + root.val;
        }
        calculateLevelSum(root.left,level+1);
        calculateLevelSum(root.right,level+1);
    }
}
