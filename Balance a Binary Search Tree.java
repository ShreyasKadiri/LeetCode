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
    List<Integer> result = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        int low=0;
        int high=result.size()-1;
        TreeNode res=buildTree(low,high);
        return res;
    }
    
    public TreeNode buildTree(int low,int high){
        if(low>high) 
            return null;
        if(low==high)
            return new TreeNode(result.get(low));
        int mid=(low+high)/2;
        TreeNode res=new TreeNode(result.get(mid));
        res.left=buildTree(low,mid-1);
        res.right=buildTree(mid+1,high);
        return res;
    }
    
    public void inOrder(TreeNode root){
        if(root==null) 
            return;
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }
}