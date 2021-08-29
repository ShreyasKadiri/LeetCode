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
    public boolean checkEqualTree(TreeNode root) {
        HashSet<Integer> set = new HashSet<Integer>();
        int sum = sumTree(root.left, set) + sumTree(root.right, set) + root.val;
        return sum % 2 == 0  && set.contains(sum/2);
    }
    
    private int sumTree(TreeNode root, HashSet<Integer> set){
        if(root == null){
            return 0;
        }
        int sum =  root.val + sumTree(root.left, set) + sumTree(root.right, set);
        set.add(sum);
        return sum;
    }
}
