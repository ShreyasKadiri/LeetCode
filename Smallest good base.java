/*
Ref: https://leetcode.com/problems/smallest-good-base/discuss/96589/Java-solution-with-hand-writing-explain
*/

import java.math.*;

public class Solution {
    public String smallestGoodBase(String n) {
        String result = "";
        long currentNumber = Long.parseLong(n);
        
        for(int k=60; k>=1; k--){
            long low=2;
            long high=currentNumber+1;
            
            
            while(low < high){
               long mid = low + (high - low)/2;
               BigInteger left = BigInteger.valueOf(mid);
               left=left.pow(k).subtract(BigInteger.ONE);
               BigInteger right = BigInteger.valueOf(currentNumber).multiply(BigInteger.valueOf(mid-1));
               
                int comparedValue=left.compareTo(right);
               if(comparedValue==0){
                   return mid+"";
               }else if(comparedValue<0){
                   low=mid+1;
               }else{
                   high=mid;
               }
             }
        }
        return result;
    }
}
