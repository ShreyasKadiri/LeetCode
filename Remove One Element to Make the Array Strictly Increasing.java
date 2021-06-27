class Solution {
    public boolean canBeIncreasing(int[] nums) {
        boolean flag = false;
        int length = 0;    
        for(int i=0; i<nums.length; i++) {
            int low = 0;
            int high = length-1;
            while(low <= high) {
                int mid = low + (high - low)/2;
                if(nums[mid] < nums[i]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            nums[low] = nums[i];
            if(low < length) {
                if(flag){
                    return false;
                }else {
                  flag = true;   
                }
            }
            if(low == length){
                length++;
            }
        }
        return true;
    }
}
