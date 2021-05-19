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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int store = (level%2 == 0) ? Integer.MIN_VALUE:Integer.MAX_VALUE;
            while(size-- > 0){
                TreeNode currentNode = queue.poll();
                if(level%2 == 0){
                    if(currentNode.val%2 == 1 && currentNode.val > store){
                        store = currentNode.val;
                    } else {
                        return false;
                    }
                } else{
                    if(currentNode.val%2 == 0 && currentNode.val < store){
                        store = currentNode.val;
                    } else {
                        return false;
                    }
                }
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            level++;
        }
        return true;
    }
}
