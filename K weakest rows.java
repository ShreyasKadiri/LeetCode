class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int weakestRows[] = new int[mat.length];
    PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>( (a,b) -> a[0]!=b[0] ? b[0] -a[0] : b[1] -a[1]);
        for(int i=0; i<mat.length; i++){
            int soldiers=0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    soldiers+=1;
                }else{
                    break;
                }
                maxHeap.offer(new int[]{soldiers,i});
            }
            while(maxHeap.size() > k){
                maxHeap.poll();
            }
         while(k>0){
             weakestRows[--k]=maxHeap.poll()[1];
         }   
        }
        return weakestRows;
    }
}
