//O(nlogn) time 
class Solution {
    public int maximumGap(int[] nums) {
        int gap = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            gap = Math.max((nums[i] - nums[i-1]), gap);
        }
        return gap;
    }
}


//O(n) time and O(n) space
class Solution{
    public int maximumGap(int[] nums) {
        int minimum = nums[0];
        int maximum = nums[0];
        for(int i=0; i<nums.length; i++){
            minimum = Math.min(minimum, nums[i]);
            maximum=Math.max(maximum, nums[i]);
        }
        if(minimum == maximum){
            return 0;
        }
        int gap = (int)Math.ceil((double)(maximum - minimum )/(nums.length-1));
        int bucketMinimum[] = new int[nums.length];
        int bucketMaximum[] = new int[nums.length];
        Arrays.fill(bucketMinimum, Integer.MAX_VALUE);
        Arrays.fill(bucketMaximum, Integer.MIN_VALUE);
        
        for(int i=0; i<nums.length; i++){
            int value = (nums[i]-minimum)/gap;
            bucketMinimum[value] = Math.min(bucketMinimum[value], nums[i]);
            bucketMaximum[value] = Math.max(bucketMaximum[value], nums[i]);
        }
            
        for(int i=0; i<bucketMinimum.length; i++){
            if(bucketMinimum[i]!=Integer.MAX_VALUE){
                gap = Math.max(gap, bucketMinimum[i]-minimum);
                minimum = bucketMaximum[i];
            }
        }    
        return gap;
    }
}
