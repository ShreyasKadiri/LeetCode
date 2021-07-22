class Solution {
    public int partitionDisjoint(int[] nums) {
        int maximumOnLeft[] = new int[nums.length];
        int minimumOnRight[] = new int[nums.length];
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        
        //Getting maximum element on the left side
        for(int i=0; i<nums.length; i++){
            maximum = Math.max(maximum, nums[i]);
            maximumOnLeft[i] = maximum;
        }
        
        
        //Getting minimum element on right side
         for(int i=nums.length-1; i>=0; i--){
            minimum = Math.min(minimum, nums[i]);
            minimumOnRight[i] = minimum;
        }
        
        for(int i=1; i<nums.length; i++){
            if(maximumOnLeft[i-1] <= minimumOnRight[i]){
                return i;
            }
        }
        return -1;
    }
}



class Solution {
    public int partitionDisjoint(int[] nums) {
        int maximumUntilCurrent = nums[0];
        int maximumInLeftPartition = nums[0];
        int partitionIndex = 0;
        for (int i=1; i<nums.length; i++) {
            maximumUntilCurrent = Math.max(maximumUntilCurrent, nums[i]);
            if (nums[i] < maximumInLeftPartition) {
                maximumInLeftPartition = maximumUntilCurrent;
                partitionIndex = i;
            }
        }
        return partitionIndex + 1;
    }
}
