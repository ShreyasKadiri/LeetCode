class Solution {
    public int singleNumber(int[] nums) {
        int singleNumber =0 ;
        for(int currentNumber  : nums){
            singleNumber^=currentNumber;
        }
        return singleNumber;
    }
}
