class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubsets = new ArrayList<>();
        dfs(nums, 0, currentSubsets, result);
        return result;
    }
    
    
    private void dfs(int nums[], int index, List<Integer> currentSubsets, List<List<Integer>> result){
        result.add(new ArrayList<>(currentSubsets));
        for(int i=index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            currentSubsets.add(nums[i]);
            dfs(nums, i+1, currentSubsets, result);
            currentSubsets.remove(currentSubsets.size()-1);
        }
        return ;
    }
}
