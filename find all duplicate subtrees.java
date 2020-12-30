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
    List<TreeNode> result =new ArrayList<>();
    HashMap<String,Integer> map =new HashMap<String,Integer>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuplicate(root);
        return result;
    }
    
    public String findDuplicate(TreeNode node){
        if(node==null) return "X";
        String leftResult=findDuplicate(node.left);
        String rightResult=findDuplicate(node.right);
        String str=Integer.toString(node.val)+"-"+leftResult+"-"+rightResult;    
        map.put(str,1+map.getOrDefault(str,0));
        if(map.get(str)==2)
        result.add(node);
        return str;
    }   
}
