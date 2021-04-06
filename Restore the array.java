class Solution {
int mod=(int)(1e9+7);
    
public int numberOfArrays(String s, int k) {
long[] dp = new long[s.length()];
long result=dpSolve(dp,s,0,k);
return (int)result;
}
    
public long dpSolve(long[] dp,String s, int index,int k){
if(index==s.length()) return 1;
if(s.charAt(index)=='0') return 0;
if(dp[index]!=0) return dp[index];
long result=0;
long element=0;
for(int i=index;i<s.length();i++){
element=element*10+(s.charAt(i)-'0');
if(element>k) break;
result+=dpSolve(dp,s,i+1,k);
result%=mod;
    }
dp[index]=result;
return result;
    }
}