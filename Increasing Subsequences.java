class Solution {
    private HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();     
        solveRecursive(nums,0,new ArrayList(),result,set);
        return result;
    }
    
public void solveRecursive(int[] nums, int i, List<Integer>curr, List<List<Integer>>result, Set<List<Integer>>set) {
        if(curr.size()>1 && set.add(new ArrayList(curr))) {
            result.add(new ArrayList(curr));}
        for (int j=i; j<nums.length; j++) {
            if (curr.size()==0 || curr.get(curr.size()-1)<=nums[j]) {
                curr.add(nums[j]);
                solveRecursive(nums,j+1,curr,result,set);
                curr.remove(curr.size()-1);  
            }
        }
    }
}