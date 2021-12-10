class Solution {
    public int numTilings(int n) {
        int mod = (int)(1e9 + 7);
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        for(int i=4; i<=n; i++) {
            dp[i] = 2*dp[i-1] % mod + dp[i-3] % mod;
            dp[i] %= mod;
        }
        return (int) dp[n];
    }
}
