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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int val=Integer.MIN_VALUE;
             for(int i=0; i<size; i++) {
               TreeNode curr = queue.poll(); 
                if(curr!=null) {
                    val=curr.val;
                    if(curr.left != null) 
                        queue.offer(curr.left);
                    if(curr.right != null) 
                        queue.offer(curr.right);
                }
            }
            if(val!=Integer.MIN_VALUE){
                result.add(val);
            }
        }
        return result;
    }
}