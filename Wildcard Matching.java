class Solution{
public boolean isMatch(String s, String p) {
        if (s==null || p==null)     return false;
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for (int j=1; j<p.length()+1; j++) {
            if (p.charAt(j-1) == '*') {
                dp[j][0]=dp[j-1][0];
            }
        }
        for (int i=1; i<s.length()+1; i++) {
            for (int j=1; j<p.length()+1; j++) {
                char charFirst=s.charAt(i - 1);
                char charSecond=p.charAt(j - 1);
                if (charFirst==charSecond || charSecond=='?')
                    dp[j][i]=dp[j-1][i-1];
                else if (charSecond=='*')
                    dp[j][i]=dp[j-1][i] || dp[j][i-1];
            }
        }
        return dp[p.length()][s.length()];
 }
}
