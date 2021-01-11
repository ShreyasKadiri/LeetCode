class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int buckets[] = new int[101];
        if(nums.length==0){
            return buckets;
        }
        for(int i=0; i<nums.length; i++){
            buckets[nums[i]]++;
        }
       
        for(int i=1; i<buckets.length; i++)
            buckets[i]+=buckets[i-1];                        
        
        for (int i=0; i<nums.length; i++)
            nums[i] = nums[i]==0 ? 0 : buckets[nums[i]-1]; 
        
        return nums;
    }
}
