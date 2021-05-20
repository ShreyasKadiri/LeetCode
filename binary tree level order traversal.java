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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> currentList = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode currentNode = queue.poll();
                currentList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            result.add(currentList);
        }
        return result;
    }
}
