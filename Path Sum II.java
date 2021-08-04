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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        pathSum(root, stack, result, targetSum);
        return result;
    }
    
    private void pathSum(TreeNode node, Stack<Integer> stack, List<List<Integer>> result, int targetSum){
        if(node == null){
            return ;
        }
        stack.push(node.val);
        int remainingSum = targetSum - node.val;
        if(node.left == null && node.right == null && remainingSum == 0){
            LinkedList<Integer> currentPath = new LinkedList<>(stack);
            result.add(currentPath);
        }
        
        pathSum(node.left, stack, result, remainingSum);
        pathSum(node.right, stack, result, remainingSum);
        stack.pop();
        
        return ;
    }
}
