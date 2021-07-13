class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
       int left=0;
        int right=0;
        int product=1;
        int count=0;
        while(right<nums.length){
           product=product*nums[right]; 
        while(product>=k){
            product/=nums[left];
            left+=1;
        }
            count+=right-left+1;
            right++;
    }
        return count;
    }
}