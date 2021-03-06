//O(n)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = -1;
        int lastIndex = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==target && firstIndex==-1) {
               firstIndex = i;
          }
            if (nums[i]==target && firstIndex!=-1) {
                 lastIndex = i;
           }
        }
        return new int[]{firstIndex, lastIndex};
    }
}


//Binary Search : O(logn)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = getFirstIndex(nums, target);
        int lastIndex = getLastIndex(nums, target);
        return new int[]{firstIndex, lastIndex};
    }
    
    public int getFirstIndex(int nums[], int target){
        int firstIndex = -1;
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                firstIndex = mid;
                high = mid - 1;
            }else if(nums[mid]<target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return firstIndex;
    }
    
    public int getLastIndex(int nums[], int target){
        int lastIndex = -1;
        int low =0;
        int high = nums.length-1;
        while(low <= high){
        int mid = low + (high - low)/2;
            if(nums[mid]== target){
                lastIndex = mid;
                low = mid+1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
        else{
            high = mid-1;
          }
        }
        return lastIndex;
      }
  }
