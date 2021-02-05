/*
Ref: https://leetcode.com/problems/smallest-good-base/discuss/96589/Java-solution-with-hand-writing-explain
*/

class Solution {
    public String smallestGoodBase(String n) {
    long currentNumber = Long.parseLong(n);
    long result = 0;
    for(int k=60; k>=2; k--){
    long low = 2;
    long high = currentNumber;
    while(low < high){
    int mid  = low + (high-low)/2;
    BigInteger left = BigInteger.valueOf(mid);
    left = left.pow(k).subtract(BigInteger.ONE);
    BigInteger rightBigInteger.valueOf(currentNumber).multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
        int comparedValue = left.compareTo(right);
        
        if(comparedValue == 0){
            return mid;
            break;
        }
        
        else if(comparedValue < 0){
            low=mid + 1;
        }else {
            high = mid;
        }
            }
        
        if(result!=0){
            break;
        }
            
        return  ""+result;
        }
}
