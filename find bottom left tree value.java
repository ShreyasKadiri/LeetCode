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
    public int findBottomLeftValue(TreeNode root) {
        int bottomLeftValue = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode currentNode = queue.poll();
                if(i == 0){
                    bottomLeftValue = currentNode.val;
                }if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
        }
        return bottomLeftValue;
    }
}
