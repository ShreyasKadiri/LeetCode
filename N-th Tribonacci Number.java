class Solution {
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }else if(n< 3){
            return 1;
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
