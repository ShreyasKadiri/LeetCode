class Solution { 
    public boolean canPartition(int[] nums) { 
        if(nums.length == 1){ 
            return false; 
        }
        int sum = 0; 
        for(int i : nums){ 
            sum += i; 
        } 
        if(sum % 2 != 0){ 
            return false; 
        } 
        return checkIfExists(nums, sum/2);
    }
    public boolean checkIfExists(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length+1][target+1];
        for(int i=0; i<dp.length; i++){ 
            dp[i][0] = true;
        }
        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = false;
        }
        for(int i=1; i<dp.length;i++){ 
            for(int j=1; j<dp[0].length; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }else{ dp[i][j] = dp[i-1][j];
                     } 
            }
        } 
        return dp[nums.length][target]; 
    } 
} 
