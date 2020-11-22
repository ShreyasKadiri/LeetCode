class Solution{
public int decodeWays(String s){
int dp[] = new int[s.length()];
dp[0]=1;
dp[1] = s.charAt(0)=='0' ? '0' : dp[0];
for(int i=2; i<=s.length(); i++){
int oneDigit = Integer.parseInt(s.substr(i-1, i));
int twoDigit = Integer.parseInt(s.substr(i-2,i));
if(oneDigit>=1){
dp[i] + = dp[i-1];
}else if(twoDigit>=10 && twoDigit<=26){
dp[i]+= dp[i-2];
}
}
return dp[s.length()];
}
}