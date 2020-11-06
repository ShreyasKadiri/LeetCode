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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null)
            return null;
        List<Double> result = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        int n=queue.size();
        double sum=0;
        for(int i=0;i<n;i++){
        TreeNode curr=queue.poll();
        sum+=curr.val;
            if(curr.left!=null) 
                queue.add(curr.left);
            if(curr.right!=null) 
                queue.add(curr.right);   
        }
            result.add(sum/n);
        }
        
        return result;
    }
}