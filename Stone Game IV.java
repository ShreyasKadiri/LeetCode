class Solution {
    public boolean winnerSquareGame(int n) {
        if(n == 1){
            return true;
        }
        boolean dp[] = new boolean[n+1];
        dp[0] = false;
        dp[1] = true;
        
        for(int i=2 ; i<=n ; i++){
            boolean result = false;
            for(int j=1 ; j*j <= i ; j++){
                result |= !dp[i-j*j];
            }
            dp[i] = result;
        }
        return dp[n];
    }
}
