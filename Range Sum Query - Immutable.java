class NumArray {

    int nums[];
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int prefixSum[] = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        return prefixSum[right] - prefixSum[left] + nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */


//without prefixsum array
class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if(i == 0){
            return nums[j];
        }
        return nums[j] - nums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
