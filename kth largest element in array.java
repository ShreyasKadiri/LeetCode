class Solution {
    public int findKthLargest(int[] nums, int k) {
       Arrays.sort(nums);
        return nums[nums.length-k];
    }
}


//HEAP
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        int ele=-1;
        for(int i:nums){
            maxHeap.add(i);
          if(maxHeap.size()>k)
            maxHeap.remove();
        }
        return maxHeap.remove();
    }
}
