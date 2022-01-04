class Solution {
    public int bitwiseComplement(int N) {
        if (N==0) {
            return 1;
        }
        int result=0;
        int m=0;
        result= ~N;
        while(N>0){
            N = N>>1;
            m = m<<1;
            m++;
        }
      return result&m;
    }
}
