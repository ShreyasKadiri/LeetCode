class Solution {
    public int maxProduct(int[] nums){
        int[] maximum = new int[nums.length];
        int[] minimum = new int[nums.length];
        maximum[0] = minimum[0] = nums[0];
        int result = nums[0];
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] > 0){
                maximum[i] = Math.max(nums[i], maximum[i-1]*nums[i]);
                minimum[i]=Math.min(nums[i], minimum[i-1]*nums[i]);
            }else{
                maximum[i] = Math.max(nums[i], minimum[i-1]*nums[i]);
                minimum[i] = Math.min(nums[i], maximum[i-1]*nums[i]);
            }
            result = Math.max(result, maximum[i]);
        }
        return result;
    }
}
