//Brute Force TC: o(2^n)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0){
            return true;
        } 
        boolean flag1 = false; 
        if (s1.length() > 0 && (s1.charAt(0) == s3.charAt(0))){
            flag1 = isInterleave(s1.substring(1), s2, s3.substring(1));
        }
        boolean flag2 = false; 
        if (!flag1 && s2.length() > 0 && (s2.charAt(0) == s3.charAt(0))){
            flag2 = isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        return flag1 || flag2;
    }
}



//DP 
class Solution {
    public boolean isInterleave(String s1, String s2, String s3){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        return solveStrings(s1,s2,s3,0,cache, 0, 0);
    }
    
    public boolean solveStrings(String s1, String s2, String s3, int currentPosition, int dp[][], int i, int j){
        if(currentPosition ==s3.length()){
            if (i==s1.length() && j==s2.length()){
                return true;
            }else{
                return false;
            }
        }
        if(i==s1.length() && j==s2.length() && currentPosition!=s3.length()){
            return false;
        }
			
        if (dp[i][j]!=0){
            return dp[i][j] == 1 ? true : false;
        }
            
			
        boolean flag1 = false;
        boolean flag2 = false;
        
        if(i<s1.length()){
          if(s1.charAt(i) ==  s3.charAt(currentPosition)){
              flag1 =  solveForStrings(i+1, j, currentPosition+1, s1, s2, s3, dp);
          }
        }
        if (j<s2.length()){
          if (s2.charAt(l2) == s3.charAt(currentPosition)){
              flag2=  helper(l1, l2 +1 , position + 1, s1, s2, s3, dp);
          }
        }
        dp[l1][l2] = (res1 || res2) == true ? 1 : -1;
        return res1 || res2;
    }
}
