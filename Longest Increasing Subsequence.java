class Solution {
    public int lengthOfLIS(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
        }
        for(int i=0; i<dp.length; i++){
            maximum = Math.max(dp[i], maximum);
        }
        return maximum;
    }
}
