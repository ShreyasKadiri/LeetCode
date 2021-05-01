public class Solution{
private int[][] dp;

public int strangePrinter(String s) {
if (s.length()<=1)
return s.length();
dp = new int[s.length()][s.length()];
char[] array=s.toCharArray();
return solve(array,0,s.length()-1,dp);
}

public int solve(char[] array, int i, int j, int[][] dp) {
if(i==j)  return 1;
if(i>j)  return 0;
if (dp[i][j]>0)
return dp[i][j];
int result=solve(array,i,j-1,dp)+1;
for(int m=i; m<j;m++)
if(array[m]==array[j])
result=Math.min(result,solve(array,i,m,dp)+solve(array,m+1,j-1,dp));
dp[i][j]=result;
return result;
 }
}