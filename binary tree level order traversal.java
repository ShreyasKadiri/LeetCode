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
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<TreeNode> currentList = new ArrayList<TreeNode>();
            for(int i=0; i<size; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
                currentList.add(queue.poll());
            }
            result.add(currentList);
        }
        return result;
    }
}
