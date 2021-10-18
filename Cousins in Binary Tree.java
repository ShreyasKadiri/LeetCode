/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution{
 public boolean isCousins(TreeNode root, int x, int y){
     if (root==null) {
         return false;
     }
     HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
    
    //Queue to perform level order traversal
    Queue<TreeNode>queue=new LinkedList<TreeNode>();
    queue.add(root);
     while (!queue.isEmpty()) {
        int size = queue.size();
        HashSet<Integer>set=new HashSet<Integer>();
        for (int i=0; i<size; i++){
            TreeNode currentNode = queue.remove();
            set.add(currentNode.val);
            if (currentNode.left!=null){
                queue.add(currentNode.left);
                map.put(currentNode.left.val, currentNode.val);
            }if (currentNode.right!=null) {
                queue.add(currentNode.right);
                map.put(currentNode.right.val, currentNode.val);
            }
        }
         if (set.contains(x) &&  set.contains(y)) {
             int firstNode = map.get(x);
             int secondNode = map.get(y);
             return firstNode!=secondNode;
         } else if(set.contains(x)||set.contains(y)){
             return false;
         }
     }
     return false;
 }
}
