class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shiftCount=0;
        //Keep right shifting these numbers till they are equal to find common bits
        while(m!=n){
            m>>=1;
            n>>= 1;
            shiftCount+=1;
        }
        //Take the result and left shift it shiftCount number of timed
        return m<<=shiftCount;
   }
} 
