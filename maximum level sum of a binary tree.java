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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
          return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode currentNode = null;
        queue.offer(root);
        queue.offer(null);
        int maximumSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int maximumLevel = 0;
        int currentLevel = 0;
        
        while(!queue.isEmpty()){
          currentSum = 0;
          currentNode = queue.poll();
          if(currentNode!=null){
            while(currentNode!=null){
            currentSum += currentNode.val;
            
            if(currentNode.left!=null){
              queue.add(currentNode.left);
            }
            
            if(currentNode.right!=null){
              queue.add(currentNode.right);
            }
            
            currentNode = queue.poll();
          }
          
          currentLevel++;
          if(maximumSum < currentSum){
            maximumSum = currentSum;
            maximumLevel = currentLevel;
          }
          
          queue.offer(null); 
          }
   
        }
      
      return maximumLevel;
    }
}
