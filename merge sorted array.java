class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i=0; i<m; i++){
            minHeap.offer(nums1[i]);
        }
          for(int i=0; i<n; i++){
            minHeap.offer(nums2[i]);
        }
         int i=0;
        while(!minHeap.isEmpty()){
            nums1[i]=minHeap.poll();
            i+=1;
        }        
    }
}
