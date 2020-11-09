/*
Approach:
1. Bezout's Identity:
If there are 2 numbers a,b such that gcd(a,b)=1 then we have another two numbers x,y such that ax + by =d
2. Two numbers a,b are said to be co-prime if gcd(a,b)=1
*/


class Solution {
    public boolean isGoodArray(int[] nums) {
        int x=nums[0];
        int y;
        for (int i: nums) {
            while (i>0) {
                y=x%i;
                x=i;
                i=y;
            }
        }
        return x==1;
}