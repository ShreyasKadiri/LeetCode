//Brute Force: O(2^n)
class Solution {
    public int fib(int n) {
        if(n<=0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}


//Three variables
class Solution {
    public int fib(int n) {
      if (n<=1) {
        return n;
    }
        int a=0;
        int b=1;
        for (int i=0; i<n-1; i++){
            int c = a + b;
            a = b;
            b = c;
    }
    return b;
    }
}



//Caching with 1D array
class Solution {
    public int fib(int n) {
        int dp[] = new int[31];
        if(n <=1){
            return n;
        }
        else if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = dp[n-1] + dp[n-2];
        
        return dp[n];
    }
}
