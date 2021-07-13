//Linear
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] >= nums[1]){
            return 0;
        }
        if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }
        
        for(int i=1; i<nums.length-1; i++){
            if(nums[i]>=nums[i-1] && nums[i]>=nums[i+1]){
                return i;
            }
        }
        return 0;
    }
}


//Binary Search
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1]){
            return 0;
        }
        if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }
        int low = 1;
        int high = nums.length-2;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] < nums[mid+1]){
                low = mid + 1;
            }else if(nums[mid] < nums[mid-1]){
                high = mid - 1;
            }
        }
        return 0;
    }
}
