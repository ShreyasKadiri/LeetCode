class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums==null ||nums.length==0)
            return false;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int totalSum=0;
        for(int i:nums){
            totalSum+=i;
        }
        int dp[][] = new int [nums.length][nums.length];
        int myScore= maxScore(nums,0,nums.length-1,totalSum,dp);
        return totalSum%2 == 0 ? myScore >=totalSum/2 : myScore > totalSum/2;        
    }
    
    
    
    public int maxScore(int nums[], int low, int high, int sumInRange, int dp[][]){
        if(low>high)
            return 0;
        if(dp[low][high]!=0)
            return dp[low][high];
        
        int opponent=Math.min(maxScore(nums,low+1,high,sumInRange-nums[low],dp),
                            maxScore(nums,low,high-1,sumInRange-nums[high],dp ));
        int ans=sumInRange-opponent;
        dp[low][high]=ans;
        return ans;
    }
}