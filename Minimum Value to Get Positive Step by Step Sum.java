public class Solution {
    public int minStartValue(int[] nums) {
          /*
        Step 1: Take prefix Sum
        Step 2: Get the minimum prefix Sum out of all
        Step 3: Find a number that needs to be added to this minimum prefix Sum from Step 2 to make it > 0
        Ex: Let minimum prefix sum be -4, add 5 to -4 which gives 1, i.e abs(minimumPrefixSum) + 1
        */
        
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
