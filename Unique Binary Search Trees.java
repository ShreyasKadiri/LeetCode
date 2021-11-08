//Catalan Numbers
class Solution{
    public int numTrees(int n) {
        return findCatalan(n);
    }
    public int findCatalan(int n) { 
        int result = 0; 
        if (n <= 1) { 
            return 1;
        } 
        for (int i=0; i<n; i++) {
            result+= findCatalan(i) * findCatalan(n-i-1); 
        } 
        return result;
    } 
}

//Dp
class Solution{
    int dp[] = new int[20];
    public int numTrees(int n) {
        if(n<=1){
            return 1;
        }if(dp[n] > 0){
            return dp[n];
        } 
        for(int i=1; i<=n; i++){
            dp[n]+= numTrees(i-1) * numTrees(n-i);
        }
        return dp[n];
    }
}

