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
    TreeNode previousNode = null;
    public void flatten(TreeNode root){
    if (root == null) {
        return;
    }
        flatten(root.right);
        flatten(root.left);
        root.right = previousNode;
        root.left = null;
        previousNode = root;
    }
}


//Stack
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
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode currentNode = stack.peek();
            stack.pop();
            if (currentNode.right != null){
                stack.push(currentNode.right);
            }
            if (currentNode.left != null){
                stack.push(currentNode.left);
            }
            if (!stack.isEmpty()){
                currentNode.right = stack.peek();
            }
            currentNode.left = null;
        }
    }
}

//Iterative
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
    public void flatten(TreeNode root) {
        TreeNode currentNode = root;
        while (currentNode != null){
            if (currentNode.left != null){
                TreeNode previousNode = currentNode.left;
                while (previousNode.right != null)
                    previousNode = previousNode.right;
                    previousNode.right = currentNode.right;
                    currentNode.right = currentNode.left;
                    currentNode.left = null;
            }
            currentNode = currentNode.right;
        }
    }
}
