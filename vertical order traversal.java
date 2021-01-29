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
        HashMap<List,List> map= new HashMap<List,List>(); 
    
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> result= new ArrayList<>();
            if(root==null) 
                return result;
            dfs(root,0,0);
            HashSet<Integer> set1 = new HashSet<Integer>();
            HashSet<Integer> set2 = new HashSet<Integer>();
            for(List<Integer> curr: map.keySet()){
                set1.add(curr.get(0));
                set2.add(curr.get(1));
            }
            List<Integer> xList= new ArrayList<Integer>();
            List<Integer> yList= new ArrayList<Integer>();
            for(Integer i:set1){
                xList.add(i);
            }
            for(Integer i:set2){
                yList.add(i);
            }
            Collections.sort(xList);
            Collections.sort(yList,Collections.reverseOrder());
            for(Integer i:xList){
                List<Integer> current = new ArrayList<>();
                for(Integer j:yList){
                    List<Integer> sort= new ArrayList<>();
                    sort.add(i);
                    sort.add(j);
                    if(map.containsKey(sort)){
                        List<Integer> finalList=map.get(sort);
                        Collections.sort(finalList);
                        for(Integer k : finalList){
                            current.add(k);
                        }
                    }
                }
                result.add(current);
            }
            
            return result;
        }
    
    
        public void dfs(TreeNode root,int x,int y){
            if(root==null)
                return;
            List<Integer> dfsList=new ArrayList<>();
            dfsList.add(x);
            dfsList.add(y);
            if(map.containsKey(dfsList)){
                List<Integer> currList=map.get(dfsList);
                currList.add(root.val);
                map.put(dfsList,currList);
            }else{
                List<Integer> currList= new ArrayList<>();
                currList.add(root.val);
                map.put(dfsList,currList);
            }
        
            dfs(root.left,x-1,y-1);
            dfs(root.right,x+1,y-1);
        }
    }
