class Solution{
    public int concatenateBinaryStrings(int n){
      int mod = 1000000007;
        long result=1;
        int digits=1;
        for(int i=2; i<=n; i++){
            digits = Integer.toBinaryString(i).length();
            result=result<<digits;
            result+=i;
            result=result%mod;
        }
        return (int)result;
    }
}
