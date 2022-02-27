/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max_width;
    HashMap<Integer, Integer> leftmost_positions;
    public int widthOfBinaryTree(TreeNode root) {
        max_width=0;
        leftmost_positions= new HashMap<Integer,Integer>();
        get_width(root, 0, 0);
        return max_width;
    }
    public void get_width(TreeNode root, int depth, int position ){
        if(root == null){
            return ;
        }
        leftmost_positions.computeIfAbsent(depth, x->position);
        max_width = Math.max(max_width, position-leftmost_positions.get(depth)+1);
        get_width(root.left, depth+1, position*2);
        get_width(root.right, depth+1, position*2+1);
    }
}
