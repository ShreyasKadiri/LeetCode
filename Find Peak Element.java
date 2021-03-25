class Solution {
    public int findPeakElement(int[] nums) {
      if(nums.length==0 || nums==null)
          return -1;
        int low=0;
        int high=nums.length-1;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>findElement(nums,mid-1) && nums[mid]>findElement(nums,mid+1)){
                return mid;
            }
            
            if(nums[mid]<findElement(nums,mid-1)){
                high=mid-1;
            }else{
                index=mid;
                low=mid+1;
            }
        }
        return index;  
    }

     public int findElement(int nums[],int i){
        if(i<0||i>=nums.length)
            return Integer.MIN_VALUE;
        return nums[i];
    }
}