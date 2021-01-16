class Solution {
 
   public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
     return nums[nums.length-k];
    }
    
   public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( (a,b) -> (b-a));
       for(int i=0; i<nums.length; i++){
           maxHeap.add(nums[i]);
       }
       while(k-- > 1){
           maxHeap.poll();
       }
     return maxHeap.peek();
    } 
    
}
