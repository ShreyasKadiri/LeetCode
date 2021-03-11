class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<Integer>();
        int sum= 0;
        int currentSum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        
        for(int i=nums.length-1; i>=0; i--){
            currentSum+=nums[i];
            sum-=currentSum;
            result.add(nums[i]);
            if(currentSum > sum){
                return result;
            }
        }
        
        return result;
    }
}
