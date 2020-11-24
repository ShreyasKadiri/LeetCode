class Solution{
public int firstIndex(int arr[], int x){
    int start =0;
    int end = arr.length-1;
    int ans=-1;
    while(start<=end){
        int mid = (start+end)/2;
        if(arr[mid]==x){
            ans = mid;
            end = mid-1;
        }
        else if(arr[mid]<x)
            start = mid+1;
        else
            end = mid-1;
    }
    
    return ans;
}

   public int lastIndex(int arr[], int x){
    int start =0;
    int end = arr.length-1;
    int ans=-1;
    while(start<=end){
        int mid = (start+end)/2;
        if(arr[mid]==x){
            ans = mid;
            start = mid+1;
        }
        else if(arr[mid]<x)
            start = mid+1;
        else
            end = mid-1;
    }
    
    return ans;
}

public int[] searchRange(int[] nums, int target) {
    
int ans1 = firstIndex(nums, target);
int ans2 = lastIndex(nums, target);
    
return new int[]{ans1, ans2};
 }
}
