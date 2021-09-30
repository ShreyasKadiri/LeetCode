class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for(int i=0; i<nums.length; i++){
            total+=nums[i];
        }
        if(total % k !=0){
            return false;
        }
        if (nums.length < k){
            return false;
        }

        int subsetSum = total/k;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, subsetSum);

    }
    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int currentSum, int subsetSum) {
        if (k == 0){
            return true;
        } 
        if (currentSum > subsetSum){
            return false;
        }
        if (currentSum == subsetSum)  {
            return canPartition(nums, visited, 0, k-1, 0, subsetSum);
        }

        for (int i=start; i<nums.length; i++) {
            if (visited[i]){
                 continue;
            }
            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, currentSum + nums[i], subsetSum)){
                return true;
            }
            visited[i] = false;
        }

        return false;
    }
}
