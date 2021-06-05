class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
      int mod=(int)(1e9+7);
      int[][] performance = new int[n][2];
        
      for(int i=0; i<n;i++){
          performance[i]=new int[] {efficiency[i], speed[i]};
      }
        
      Arrays.sort(performance,(a,b)->b[0]-a[0]);
      PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k,(a, b)-> a-b);
      long result=Long.MIN_VALUE;
      long totalSpeed=0;
     
    for(int[] currentPerformance : performance) {
        if(maxHeap.size() == k)
            totalSpeed = totalSpeed - maxHeap.poll();  
            maxHeap.add(currentPerformance[1]);
            totalSpeed = totalSpeed + currentPerformance[1];
	        result=Math.max(result, totalSpeed*currentPerformance[0]);
        }
        return (int)(result%mod);
    }
}
