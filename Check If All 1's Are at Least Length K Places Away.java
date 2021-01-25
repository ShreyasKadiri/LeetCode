class Solution {
   public boolean kLengthApart(int[] nums, int k) {
        int prev=-1;
        int i=0;
       
        while(i<nums.length && nums[i]==0)
            i++;
       
       if(i<nums.length && nums[i]==1){
            prev=i;
            i++;            
        }
       
        while(i<nums.length){
            if(nums[i]==1){
                if(i-prev-1<k)
                    return false;
                prev=i;
            }
            i++;
        }
        return true;
    }
}
