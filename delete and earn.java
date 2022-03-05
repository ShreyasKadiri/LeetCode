class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] frequency = new int[10001];
        int[] dp = new int[10001];
        
        //Storing the frequency of each element
        for(int i=0; i<nums.length; i++){
            frequency[nums[i]]++; 
        }
        dp[1] = frequency[1];
        for(int i=2 ;i<10001 ;i++){
            dp[i] = Math.max(dp[i-1] , frequency[i]*i + dp[i-2]);
        }
        return dp[10000];
    }
}
