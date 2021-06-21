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
     List<Integer> inOrderTraversal = new ArrayList<Integer>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root);
        int sum = 0;
        for(int nodeValue : inOrderTraversal){
            if(nodeValue>=low && nodeValue<=high){
                sum+= nodeValue;
            }
        }
        return sum;
    }
    
    private void inOrder(TreeNode root){
        while(root!=null){
            inOrder(root.left);
            inOrderTraversal.add(root.val);
            inOrder(root.right);
        }
    }
}
