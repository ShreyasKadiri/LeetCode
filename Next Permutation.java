class Solution {
    public void nextPermutation(int[] nums) {
        // find the first pair that the preceding element is less than the following one
        // 1 2 3
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // 3 2 1
        // Find the first element, which is greater the nums[i]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            // swap them
            swap(nums, i, j);
        }

        // reverse
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
         
