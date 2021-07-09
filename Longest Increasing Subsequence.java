class Solution {
    public int lengthOfLIS(int[] nums) {
        int maximum = 1;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            maximum = Math.max(dp[i], maximum);
        }
        return maximum;
    }
}
