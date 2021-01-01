class Solution{
    public int countFriendsPairing(int n){
        if(n<=0){
            return 0;
        }
        
        int dp[] = new int[n];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        
        return dp[n];
    }
}
