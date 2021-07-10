class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)-> Math.abs(a[0]-a[1]) - Math.abs(b[0]-b[1]));
        
        for(int i=0; i<nums.length-1; i++){
            minHeap.add(new int[]{nums[i], nums[i+1], i+1});
        }
        
        int index = 0;
        while(!minHeap.isEmpty()){
            int[] poppedElement = minHeap.poll();
            if(++index==k){
                return  Math.abs(poppedElement[0] - poppedElement[1]);
            }
            
            if(poppedElement[2] == nums.length-1){
                continue;
            }
            minHeap.add(new int[]{poppedElement[0], nums[poppedElement[2]+1], poppedElement[2]+1});
        }
        return 0;
    }
}
