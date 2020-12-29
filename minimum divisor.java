class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for (int i:nums) 
            high=Math.max(high,i);
        
        while(low<high) {
            int mid=low+(high-low)/2;
            int sum=findSum(nums,mid);
            if(sum>threshold) 
                low=mid+1;
            else 
                high=mid;
        }
        return low;
    }
    
    private int findSum(int[] nums, int div) {
        int sum=0;
        for(int i:nums) {
            if(i%div==0)
                sum+=i/div;
            else 
                sum+=(i/div+1);
        }
        return sum;
    }
}
