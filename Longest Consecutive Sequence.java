class Solution {
    public int longestConsecutive(int[] nums) {
        int store[] = new int[nums.length];
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            if(store[nums[i]] == 1){
                store[nums[i]]++;
            }
            minimum = Math.min(minimum, nums[i]);
            maximum = Math.max(maximum, nums[i]);
        }
        
        int i = 0;
        int j = maximum;
        
        while(i <= maximum){
            if(store[i] >=1 ){
                count+=1;
            }else {
                count = 0;
            }
            i++;
        }
        return count;
    }
}
