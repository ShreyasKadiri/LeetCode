class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length+1][dungeon[0].length+1];
        for (int i=0; i<=dungeon.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[dungeon.length][dungeon[0].length-1] = 1;
        dp[dungeon.length-1][dungeon[0].length] = 1;
        for (int i=dungeon.length-1; i>=0; i--) {
            for (int j=dungeon[0].length-1; j>=0; j--){
                int minimum = Math.min(dp[i+1][j],
                   dp[i][j+1]) - dungeon[i][j];
                if (minimum < 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = minimum;
                }
            }
        }
        return dp[0][0];
    }
}
