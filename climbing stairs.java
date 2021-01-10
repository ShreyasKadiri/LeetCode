class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int f[] = new int[n+2];  
        int i; 
        f[0]=1; 
        f[1]=1; 
    for(i=2; i<=n; i++) { 
       f[i]=f[i-1] + f[i-2]; 
    } 
    return f[n];
  }
}
