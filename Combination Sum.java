class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        } 
        dfs(result, new ArrayList<>(), nums, 0, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> currentSubsets, 
                     int[] nums, int sum, int target, int index) {
        if (sum == target) {
            result.add(new ArrayList(currentSubsets));
            return;
        }

        for (int i=index; i<nums.length; i++) {
            if (nums[i] + sum <= target) {
                currentSubsets.add(nums[i]);
                dfs(result, currentSubsets, nums, sum+nums[i], target, i);
                currentSubsets.remove(currentSubsets.size() - 1);
            }
        }
    }
}
