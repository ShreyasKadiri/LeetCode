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

/*Approach
1)add :  node  and   if  node is a leaf ,return
2) If root.left!=null add : "(" + left subtree + ")" , else add:  "(" + ")" ,if we do not add "()" in later case we will get the tree wrong
3)If root.right != null , add : "(" + right subtree + ")" , otherwise we need not to add : "(" + ")"
*/
class Solution {
	public String tree2str(TreeNode root) {
	   StringBuilder sb = new StringBuilder();
		if(root!=null)
			formString(root,sb);
		return sb.toString();
	}
	private void formString(TreeNode root , StringBuilder sb){
		sb.append(root.val);
		if(root.left==null && root.right==null)
			return;
		sb.append("(");
		if(root.left!=null)
			formString(root.left,sb);
		sb.append(")");
		if(root.right!=null){
			sb.append("(");
			form(root.right,sb);
			sb.append(")");
		}
	}
}
