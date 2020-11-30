class Solution {
    public int rangeBitwiseAnd(int m, int n) {
       while(n>m)
           n=n&n-1;
            return m&n;
    }
}

//Another method
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count=0;
       while(m!=n){
           m>>=1;
           n>>=1;
           count+=1;
          }
        return m<<=count;
   }
} 
