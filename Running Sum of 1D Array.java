class Solution {
    public int[] runningSum(int[] nums) {
        int runningSums[] = new int[nums.length];
        runningSums[0]= nums[0];
        for(int i=1; i<nums.length; i++){
            runningSums[i]=runningSums[i-1]+nums[i];
        }
        return runningSums;
    }
}
