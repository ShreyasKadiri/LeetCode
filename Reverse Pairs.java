//Application of divide and conquer(Merge Sort)
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    public int mergeSort(int[] nums, int low, int high) {
        if (low>=high) 
            return 0;
        int result=0;
        int mid=low+(high-low)/2;
        result+=mergeSort(nums,low,mid);
        result+=mergeSort(nums,mid+1,high);
        result+=merge(nums,low,mid,high);
        return result;
    }

    public int merge(int[] nums, int low, int mid, int high) {
        int count=0;
        int[] a=new int[high-low+1];
        int index=0;
        int i=low;
        int j=mid+1;
        while (i<=mid && j<=high) {
            if ((long)nums[i] > 2*(long)nums[j]) {
                count+=mid-i+1;
                j++;
            } 
            else 
                i++;
        }
        i=low;
        j=mid+1;
        while (i<=mid && j<=high) {
            if (nums[i]>nums[j]) {
                a[index++]=nums[j];
                j++;
            } 
            else 
                a[index++]=nums[i++];
        }
        while (i<=mid) {
            a[index++]=nums[i++];
        }
        while (j<=high) {
            a[index++] = nums[j++];
        }
        System.arraycopy(a,0,nums,low,high-low+1);
        return count;
    }
}