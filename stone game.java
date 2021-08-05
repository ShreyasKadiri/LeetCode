class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp  = new int[piles.length][piles.length];
        
        for (int i=0; i<piles.length; i++){
            dp[i][i] = piles[i];
        }
        
        for (int j=1; j<piles.length; j++){
            for (int i=0; i<piles.length-j; i++){
                dp[i][i+j] = Math.max(piles[i] - dp[i+1][i+j], piles[i+j] - dp[i][i+j-1]);
            }
        }
        return dp[0][piles.length-1]>0;
    }
}
