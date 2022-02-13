class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 1) {
            return result;
        }
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> currentSubsets, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList(currentSubsets));
            return;
        }
        currentSubsets.add(nums[index]);
        dfs(result, currentSubsets, nums, index+1);
        currentSubsets.remove(currentSubsets.size() - 1);
        dfs(result, currentSubsets, nums, index+1);
    }
}
