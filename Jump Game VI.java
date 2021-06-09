class Solution {
    public int maxResult(int[] nums, int k){
        //PriorityQueue will contain score and index
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        heap.offer(new int[]{nums[0], 0});
        int maximumScore = nums[0];
        for(int i=1; i<nums.length; i++) {
            while(!(i- heap.peek()[1] <= k)) {
                heap.poll();
            }
            int[] currentElement = heap.peek();
            maximumScore  = currentElement[0] + nums[i];
            heap.offer(new int[]{maximumScore, i});
        }
        return maximumScore;
    }
}
