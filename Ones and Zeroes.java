class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs==null || m<0 || n<0) 
            return 0;
        int[][] dp=new int[m+1][n+1];
        for(String curr : strs){
            int onesCount= (int)curr.chars().filter(num -> num=='1').count();
            int zeroesCount=curr.length()-onesCount;
            for(int i=m; i>=zeroesCount; i--){
                for(int j=n; j>=onesCount; j--){
                    dp[i][j]=Math.max(dp[i][j], dp[i-zeroesCount][j-onesCount]+1);
                }
            }
        }
        return dp[m][n];
    }
}