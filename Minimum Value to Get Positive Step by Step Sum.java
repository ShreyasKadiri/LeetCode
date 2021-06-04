public class Solution {
    public int minStartValue(int[] nums) {
        int[] prefixSum = new int[nums.length]; 
        prefixSum[0] = nums[0];
        int minimumPrefixSum = prefixSum[0];
        for(int i=1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
            minimumPrefixSum = Math.min(minimumPrefixSum, prefixSum[i]);
        }
        if(minimumPrefixSum > 0){
            return 1;
        }else{
            return 1 + -1*minimumPrefixSum;
        }
    }
}
