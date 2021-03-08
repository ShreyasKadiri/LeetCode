/*
Ref: https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/516968/JavaC%2B%2BPython-Easy-and-Concise

Approach:
1. The total number of all permutation obviously eauqls to 2n!.
2. For each pair, the order is determined, so we need to divide by 2.
3. So the final result is (2n)!/(2^n)

*/

class Solution {
    public int countOrders(int n) {
        if(n==1){
            return 1;
        }
         
        int result = 0;
        int mod  = (int)(1e9) + 7;
        
        for(int i=1; i<=2*n; i++){
            if(i%2==1){
                result =  (result * i)%mod;
            }else {
                result = ((result * i )/2)%mod;
            }
        }
        
        return result;
    }
}
