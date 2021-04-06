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
    List<Integer> result= new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    int max=0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null)
            return new int []{};
        dfs(root); 
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(max==entry.getValue()){
               result.add(entry.getKey());
            }
        } 
      return result.stream().mapToInt(i->i).toArray();  
    }
    
    public int dfs(TreeNode root){
        if(null==root)
            return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        int sum=left+root.val+right;
        map.put(sum,map.getOrDefault(sum,0)+1);
        max=Math.max(max,map.get(sum));
        return sum;
    }
}