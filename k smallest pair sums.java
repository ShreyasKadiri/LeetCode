class Solution{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for(int i=0; i<nums2.length; i++){
            // {value, row, col}
            heap.add(new int[]{nums2[i] + nums1[0], row, 0}); 
        }

        while(!queue.isEmpty()) {
            int[] popped = heap.poll();
            result.add(new ArrayList<>(Arrays.asList(nums1[popped[2]], nums2[popped[1]])));
            k--;
            if(k == 0){
                return result;
            } 

            popped[2]++;
            if(popped[2] == nums1.length){
                continue;
            }
            popped[0] = nums1[popped[2]] + nums2[popped[1]];
            heap.add(popped);
        }
        return result;
    }
}
