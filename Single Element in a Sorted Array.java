class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low < high) {
            mid = low +(high - low)/2;
            if((mid%2==0 && nums[mid] == nums[mid+1]) || (mid%2!=0 && nums[mid] == nums[mid-1])){
                low = mid+1;
            }else {
                high=mid;
            }        
        } 
        return nums[low];
    }
}
