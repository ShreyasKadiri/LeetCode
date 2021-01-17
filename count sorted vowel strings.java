class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][6];
        for (int i=1; i<=n; ++i)
            for (int k=1; k<=5; ++k)
                dp[i][k] = dp[i][k-1] + (i>1 ? dp[i-1][k] : 1);
        return dp[n][5];
    }
}
