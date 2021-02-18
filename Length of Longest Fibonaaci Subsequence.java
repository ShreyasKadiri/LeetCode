class Solution {
     public int lenLongestFibSubseq(int[] A) {
        int max=0;
        int[][] dp = new int[A.length][A.length];
        for (int i=2; i<A.length; i++) {
            int l=0;
            int h=i-1;
	        while (l<h) {
                int sum=A[l]+A[h];
                if (sum>A[i]) {
                    h--;  
                } else if (sum<A[i]) {
                    l++;
                } else {
                    dp[h][i]=dp[l][h]+1;
                    max=Math.max(max,dp[h][i]);
                    h--;
                    l++;
                }
            }
        }
        return max==0 ? 0 : max+2;
    }
}