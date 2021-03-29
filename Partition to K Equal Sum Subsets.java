class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        int max=0;
        for(int i:nums) {
            sum+=i;
            max=Math.max(max,i);
        }
        if(sum%k!=0 || max>sum/k) {
            return false;}
        return canPartition(nums,k, new boolean[nums.length], sum/k, 0,0);
    }
    
private boolean canPartition(int[] nums,  int k, boolean[] visited, int targetSum, int currSum, int nextIndexToCheck) {
if(k==0){ return true; }
if(currSum==targetSum) {
return canPartition(nums, k-1, visited,targetSum,0,0);
}
        
for (int i=nextIndexToCheck; i<nums.length; i++) {
    if (!visited[i] && currSum+nums[i]<=targetSum) {
       visited[i]=true;
        if(canPartition(nums, k, visited, targetSum, currSum+nums[i], i+1)) {
                    return true;}
                visited[i]=false;
            }
        }
        return false;
    }
}
